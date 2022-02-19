package com.music.quiz.dto;

public record AnswerRequestDto (
        Long quizId,
        Long userId,
        Long userAnswer
) {}
