package com.banquemisr.seed;

import com.banquemisr.dto.ParticipantDto;
import com.banquemisr.service.ParticipantService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Log4j2
@Component
public class Seed {

    @Autowired
    ParticipantService participantService;

    @EventListener
    public void startSeed(ContextRefreshedEvent contextRefreshedEvent) {
        participantSeeder();
    }

    void participantSeeder() {
        if(participantService.getAllParticipants().isEmpty()) {
            String[] participantNames = {"Mohamed", "Ahmed", "Hussien", "Bino", "Zooz", "Ibrahem", "Shafii", "Nour", "Khaled", "Nemr", "Tata", "Tarek"};

            for (String participantName : participantNames) {
                ParticipantDto participant = new ParticipantDto(participantName);
                participantService.createParticipant(participant);
            }
            log.info("Database Seeder is Complete");
        } else {
            log.info("Database Seeder not Required");
        }
    }
}
