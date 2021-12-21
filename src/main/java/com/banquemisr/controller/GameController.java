package com.banquemisr.controller;

import com.banquemisr.dto.GameDto;
import com.banquemisr.service.GameService;
import com.banquemisr.service.impl.GameServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import static com.banquemisr.api.response.ApiResponseHelper.OKApiResponse;

@RestController
@RequestMapping("/match")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public ResponseEntity createMatch(@RequestBody GameDto gameDto) {
        return OKApiResponse(gameService.create(gameDto));
    }

    @GetMapping
    public ResponseEntity getMatchesForActiveRound() {
        return OKApiResponse(gameService.getActiveRoundGames());
    }

    @PatchMapping("/{id}/winner/{winnerId}")
    public ResponseEntity updateGameResults(@PathVariable("id") int gameId, @PathVariable("winnerId") int winnerId) {
        return OKApiResponse(gameService.updatedGameResult(gameId, winnerId));
    }
}
