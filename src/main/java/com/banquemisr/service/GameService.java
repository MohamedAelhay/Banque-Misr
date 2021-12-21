package com.banquemisr.service;

import com.banquemisr.dto.GameDto;
import com.banquemisr.model.Game;
import com.banquemisr.model.Participant;
import com.banquemisr.model.Round;

import java.util.List;
import java.util.Map;

public interface GameService {
    GameDto create(GameDto gameDto);

    List<GameDto> getActiveRoundGames();

    List<Game> getGamesByRound(Round round);

    void generateRoundGames(Round round, Map<Integer, Participant> participantMap);

    GameDto updatedGameResult(long gameId, long winnerId);
}
