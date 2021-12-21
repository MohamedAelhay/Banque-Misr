package com.banquemisr.service.impl;

import com.banquemisr.model.Round;
import com.banquemisr.dto.RoundDto;
import com.banquemisr.service.RoundService;
import org.springframework.stereotype.Service;
import com.banquemisr.repository.RoundRepository;
import com.banquemisr.api.exception.RoundNotComplete;
import com.banquemisr.api.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RoundServiceImpl extends BaseService implements RoundService {

    @Autowired
    private RoundRepository roundRepository;

    @Override
    public Round createRound() {
        Round round = new Round();
        round.setActive(true);
        return roundRepository.save(round);
    }

    @Override
    public RoundDto endRound(long roundId) {
        Round round = roundRepository.findById(roundId)
                .orElseThrow(() -> new NotFoundException("Round with ID " + roundId));

        round.getGames().forEach(game -> {
            if(game.getWinner() == null) {
                throw new RoundNotComplete();
            }
        });

        startRoundGeneratorThread();

        return this.dataMapperUtil.convertToDto(closeRound(round));
    }

    @Override
    public Round closeRound(Round round) {
        round.setActive(false);
        return roundRepository.save(round);
    }

    @Override
    public Round getActiveRound() {
        return roundRepository.getActiveRound(true).orElseThrow(() -> new NotFoundException("No Active Round at this moment"));
    }
}
