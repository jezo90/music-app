package com.music.quiz.model;

public record QuizRequest(
        Long albumId,
        Long artistId,
        Integer numberOfWords) {
}
