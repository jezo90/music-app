package com.music.quiz.dto;

public record QuizCreateDto(
        Long firstTrackId,
        String firstTrackTitle,
        Long secondTrackId,
        String secondTrackTitle,
        Long thirdTrackId,
        String thirdTrackTitle,
        String words,
        Long correctAnswerId) {
}
