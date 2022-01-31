package com.music.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> EmailFound(HandledException ex) {
        EntityErrorResponse postErrorRes = new EntityErrorResponse(
                ex.getCode(),
                ex.getMessage(),
                LocalDateTime.now());

        return ResponseEntity.status(ex.getCode()).body(postErrorRes);
    }
}
