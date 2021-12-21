package com.banquemisr.service.impl;

import com.banquemisr.model.Game;
import com.banquemisr.model.Round;
import com.banquemisr.model.Participant;
import com.banquemisr.dto.ParticipantDto;
import com.banquemisr.service.GameService;
import org.springframework.stereotype.Service;
import com.banquemisr.job.RoundGeneratorThread;
import com.banquemisr.service.ParticipantService;
import org.springframework.context.ApplicationContext;
import com.banquemisr.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.banquemisr.api.exception.MaxParticipantNumberException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipantServiceImpl extends BaseService implements ParticipantService {

    @Autowired
    private GameService gameService;

    @Autowired
    private ParticipantRepository participantRepository;

    private final long PARTICIPANT_COUNT = 12;

    @Override
    public List<ParticipantDto> getAllParticipantsDto(){
        return getAllParticipants()
                .stream()
                .map(this.dataMapperUtil::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ParticipantDto createParticipant(ParticipantDto participantDto){
        if(isParticipantCountComplete()){
            throw new MaxParticipantNumberException();
        }

        Participant savedParticipant = participantRepository.save(this.dataMapperUtil.convertToEntity(participantDto));

        if(isParticipantCountComplete()) {
            startRoundGeneratorThread();
        }

        return this.dataMapperUtil.convertToDto(savedParticipant);
    }

    private boolean isParticipantCountComplete(){
        return participantRepository.count() >= PARTICIPANT_COUNT;
    }

    @Override
    public List<Participant> getAllParticipants(){
        return participantRepository.findAll();
    }

    @Override
    public List<Participant> getRoundParticipants(Round round) {
        if(round == null) {
            return getAllParticipants();
        }

        return gameService.getGamesByRound(round).stream().map(Game::getWinner).collect(Collectors.toList());
    }
}
