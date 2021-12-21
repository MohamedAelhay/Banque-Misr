package com.banquemisr.service.impl;

import com.banquemisr.model.League;
import com.banquemisr.model.Participant;
import com.banquemisr.notifier.EmailNotifier;
import com.banquemisr.repository.LeagueRepository;
import com.banquemisr.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class LeagueServiceImpl extends BaseService implements LeagueService {
    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private EmailNotifier emailNotifier;

    @Override
    public void submitChampion(Participant participant) {
        League league = new League();
        league.setChampion(participant);

        league = leagueRepository.save(league);

        try {
            emailNotifier.sendEmail(league.getChampion());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void submitTest() {
        Participant participant = new Participant();
        participant.setName("Mohamed");
        try {
            emailNotifier.sendEmail(participant);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
