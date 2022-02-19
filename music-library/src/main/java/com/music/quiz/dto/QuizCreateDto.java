package com.music.quiz.dto;

public record QuizCreateDto(
        Long userId,
        Long firstTrackEntity,
        Long secondTrackEntity,
        Long thirdTrackEntity,
        String words,
        Long correctAnswer) {
}
