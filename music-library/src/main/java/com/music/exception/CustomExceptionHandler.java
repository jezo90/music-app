package com.music.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> EntityNotFound(EntityNotFoundException ex) {
        EntityErrorResponse postErrorRes = new EntityErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now());

        return new ResponseEntity<>(postErrorRes, HttpStatus.NOT_FOUND);
    }
}
