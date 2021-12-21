package com.banquemisr.controller;

import com.banquemisr.service.RoundService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import static com.banquemisr.api.response.ApiResponseHelper.OKApiResponse;

@RestController
@RequestMapping("/round")
public class RoundController {

    @Autowired
    private RoundService roundService;

    @PutMapping("/{id}")
    public ResponseEntity endRound(@PathVariable("id") long roundId) {
        return OKApiResponse(roundService.endRound(roundId));
    }
}
