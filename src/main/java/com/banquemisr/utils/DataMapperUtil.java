package com.banquemisr.utils;

import com.banquemisr.model.Round;
import com.banquemisr.model.Game;
import com.banquemisr.dto.GameDto;
import com.banquemisr.dto.RoundDto;
import org.modelmapper.ModelMapper;
import com.banquemisr.model.Participant;
import com.banquemisr.dto.ParticipantDto;
import org.springframework.stereotype.Component;

@Component
public class DataMapperUtil {

    private ModelMapper modelMapper;

    DataMapperUtil() {
        this.modelMapper = new ModelMapper();
    }

    public Participant convertToEntity(ParticipantDto participantDto){
        return modelMapper.map(participantDto, Participant.class);
    }

    public ParticipantDto convertToDto(Participant participant){
        return modelMapper.map(participant, ParticipantDto.class);
    }

    public Game convertToEntity(GameDto matchDto){
        return modelMapper.map(matchDto, Game.class);
    }

    public GameDto convertToDto(Game match){
        return modelMapper.map(match, GameDto.class);
    }

    public Round convertToEntity(RoundDto roundDto){
        return modelMapper.map(roundDto, Round.class);
    }

    public RoundDto convertToDto(Round round){
        return modelMapper.map(round, RoundDto.class);
    }
}
