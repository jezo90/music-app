package com.music.quiz.dto;

public record QuizCreateDto(
        Long trackEntity1,
        Long trackEntity2,
        Long trackEntity3,
        String words,
        Long correctAnswer) {
}
