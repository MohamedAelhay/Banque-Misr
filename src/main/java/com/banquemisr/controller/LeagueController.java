package com.banquemisr.controller;

import com.banquemisr.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.banquemisr.api.response.ApiResponseHelper.OKApiResponse;

@RestController
@RequestMapping("/league")
public class LeagueController {
    @Autowired
    private LeagueService leagueService;

    @GetMapping
    public ResponseEntity submitChampion(){
        leagueService.submitTest();
        return OKApiResponse(null);
    }
}
