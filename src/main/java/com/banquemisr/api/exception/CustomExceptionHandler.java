package com.banquemisr.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;

import static com.banquemisr.api.response.ApiResponseHelper.*;


@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler
    public ResponseEntity handleException(Exception exception){
        return BadRequestApiResponse(exception.getMessage(), Collections.singletonList(exception.getLocalizedMessage()));
    }

    @ExceptionHandler(value = {MaxParticipantNumberException.class})
    public ResponseEntity handleException(){
        return MaxParticipantResponse("Max Participant Number has been Reached");
    }

    @ExceptionHandler
    public ResponseEntity handleException(NotFoundException notFoundException){
        return NotFound("Can't Find " + notFoundException.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity handleException(NotGameParticipant notGameParticipant){
        return NotFound("Please Choose Valid Participant");
    }

    @ExceptionHandler
    public ResponseEntity handleException(RoundNotComplete roundNotComplete){
        return InValid("Round Not Complete");
    }
}
