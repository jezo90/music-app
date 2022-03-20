package com.music.quiz.dto;


public record QuizResponseDto(
        Long userId,
        Long firstTrackId,
        String firstTrackTitle,
        Long secondTrackId,
        String secondTrackTitle,
        Long thirdTrackId,
        String thirdTrackTitle,
        String words,
        Long correctAnswerId,
        Long userAnswerId
) {
}

