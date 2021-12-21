package com.banquemisr.job;

import com.banquemisr.model.Participant;
import com.banquemisr.model.Round;
import com.banquemisr.service.GameService;
import com.banquemisr.service.LeagueService;
import com.banquemisr.service.ParticipantService;
import com.banquemisr.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class RoundGeneratorThread extends Thread {
    @Autowired
    private GameService matchService;

    @Autowired
    private RoundService roundService;

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private ParticipantService participantService;

    private final int MAX = 100;

    public void run() {

        Round activeRound = roundService.getActiveRound();
        List<Participant> participants = participantService.getRoundParticipants(activeRound);

        if(activeRound != null) {
            roundService.closeRound(activeRound);
        }

        if(participants.size() == 1){
            leagueService.submitChampion(participants.get(0));
            return;
        }

        activeRound = roundService.createRound();

        Map<Integer, Participant> participantMap = new HashMap<>();
        fillParticipantMap(participants, participantMap);

        matchService.generateRoundGames(activeRound, participantMap);
    }

    private void fillParticipantMap(List<Participant> participants, Map<Integer, Participant> participantMap){
        Random random = new Random();
        Set<Integer> randNums = new HashSet<>();
        Integer randomKey = random.nextInt(MAX);
        for (Participant participant: participants){
            while(true){
                if(!randNums.contains(randomKey)){
                    randNums.add(randomKey);
                    break;
                }
                randomKey = random.nextInt(MAX);
            }

            participantMap.put(randomKey, participant);
        }
    }
}
