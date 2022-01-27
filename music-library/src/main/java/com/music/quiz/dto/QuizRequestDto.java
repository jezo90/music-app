package com.music.quiz.dto;

public record QuizRequestDto(
        Long albumId,
        Long artistId,
        Integer numberOfWords) {
}

