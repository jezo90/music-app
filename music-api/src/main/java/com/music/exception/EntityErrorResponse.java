package com.music.exception;

import java.time.LocalDateTime;

public record EntityErrorResponse(
        Integer status,
        String message,
        LocalDateTime timestamp
) {
}