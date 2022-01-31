package com.music.exception;

import java.time.LocalDateTime;

public record EntityErrorResponse(
        int status,
        String message,
        LocalDateTime timestamp
) {
}