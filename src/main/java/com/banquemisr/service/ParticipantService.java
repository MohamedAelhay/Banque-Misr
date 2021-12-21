package com.banquemisr.service;

import com.banquemisr.dto.ParticipantDto;
import com.banquemisr.model.Participant;
import com.banquemisr.model.Round;

import java.util.List;

public interface ParticipantService {
    List<ParticipantDto> getAllParticipantsDto();

    ParticipantDto createParticipant(ParticipantDto participantDto);

    List<Participant> getAllParticipants();

    List<Participant> getRoundParticipants(Round round);
}
