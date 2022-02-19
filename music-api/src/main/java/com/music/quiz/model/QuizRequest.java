package com.music.quiz.model;

public record QuizRequest(
        Long userId,
        Long albumId,
        Long artistId,
        Integer numberOfWords) {
}
