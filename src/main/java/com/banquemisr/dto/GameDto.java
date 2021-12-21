package com.banquemisr.dto;

import com.banquemisr.model.Participant;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDto extends BaseDto {
    private ParticipantDto winner;

    private Participant participantOne;

    private Participant participantTwo;

    private LocalDateTime matchDate;
}
