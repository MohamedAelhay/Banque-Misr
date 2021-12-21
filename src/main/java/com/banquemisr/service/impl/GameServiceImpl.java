package com.banquemisr.service.impl;

import com.banquemisr.api.exception.NotFoundException;
import com.banquemisr.api.exception.NotGameParticipant;
import com.banquemisr.dto.GameDto;
import com.banquemisr.model.Game;
import com.banquemisr.model.Round;
import com.banquemisr.service.GameService;
import com.banquemisr.service.RoundService;
import com.banquemisr.utils.DateUtil;
import com.banquemisr.model.Participant;
import org.springframework.stereotype.Service;
import com.banquemisr.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl extends BaseService implements GameService {

    @Autowired
    private RoundService roundService;

    @Autowired
    private GameRepository gameRepository;

    @Override
    public GameDto create(GameDto gameDto) {
        Game game = this.dataMapperUtil.convertToEntity(gameDto);

        Game savedGame = gameRepository.save(game);

        return this.dataMapperUtil.convertToDto(savedGame);
    }

    @Override
    public List<GameDto> getActiveRoundGames() {
        Round round = roundService.getActiveRound();

        return getGamesByRound(round).stream().map(this.dataMapperUtil::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<Game> getGamesByRound(Round round) {
        return gameRepository.findAllByRound(round);
    }

    @Override
    public void generateRoundGames(Round round, Map<Integer, Participant> participantMap) {
        List<Integer> keys = new ArrayList<>(participantMap.keySet());
        Collections.sort(keys);

        Game game = new Game();
        List<Game> games = new ArrayList<>();

        int counter = 0;
        int days = 0;

        if(keys.size() % 2 != 0){
            Integer lastKey = keys.get(keys.size()-1);
            keys.remove(keys.size()-1);
            game.setRound(round);
            game.setParticipantOne(participantMap.get(lastKey));
            game.setWinner(participantMap.get(lastKey));
            game.setMatchDate(DateUtil.addDays(days).toLocalDateTime());
            counter++;
            games.add(game);
        }

        for (int i = 0; i < keys.size(); i++){
            game = new Game();
            game.setRound(round);
            game.setParticipantOne(participantMap.get(keys.get(i++)));
            game.setParticipantTwo(participantMap.get(keys.get(i)));
            if(counter == 3) {
                days++;
                counter = -1;
            }
            counter++;
            game.setMatchDate(DateUtil.addDays(days).toLocalDateTime());
            games.add(game);
        }

        gameRepository.saveAll(games);
    }

    @Override
    public GameDto updatedGameResult(long gameId, long winnerId) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new NotFoundException("Game with ID " + gameId));

        if(game.getParticipantOne().getId().equals(winnerId)) {
            game.setWinner(game.getParticipantOne());
        } else if(game.getParticipantTwo().getId().equals(winnerId)) {
            game.setWinner(game.getParticipantTwo());
        } else {
            throw new NotGameParticipant();
        }

        return this.dataMapperUtil.convertToDto(gameRepository.save(game));
    }
}
