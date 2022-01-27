package com.music.quiz.dto;

public record QuizCreateDto(
        Long firstTrackEntity,
        Long secondTrackEntity,
        Long thirdTrackEntity,
        String words,
        Long correctAnswer) {
}
