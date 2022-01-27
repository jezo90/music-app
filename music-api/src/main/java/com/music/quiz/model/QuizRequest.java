package com.music.quiz.model;

public record QuizRequest(
        Long album_id,
        Long artist_id,
        int numberOfWords) { }
