package com.banquemisr.service;

import com.banquemisr.dto.RoundDto;
import com.banquemisr.model.Round;

public interface RoundService {
    Round createRound();

    RoundDto endRound(long roundId);

    Round closeRound(Round round);

    Round getActiveRound();
}
