package com.music.quiz.model;

public record AnswerRequest (
    Long quizId,
    Long userId,
    Long userAnswer
) {}
