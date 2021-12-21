package com.banquemisr.controller;

import com.banquemisr.dto.ParticipantDto;
import org.springframework.http.ResponseEntity;
import com.banquemisr.service.impl.ParticipantServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import static com.banquemisr.api.response.ApiResponseHelper.OKApiResponse;

@RestController
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    private ParticipantServiceImpl participantService;

    @GetMapping
    public ResponseEntity index() {
        return OKApiResponse(participantService.getAllParticipantsDto());
    }

    @PostMapping
    public ResponseEntity createParticipant(@RequestBody ParticipantDto participantDto) {
        return OKApiResponse(participantService.createParticipant(participantDto));
    }
}
