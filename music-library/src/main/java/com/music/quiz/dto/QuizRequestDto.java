package com.music.quiz.dto;

public record QuizRequestDto(
        Long userId,
        Long albumId,
        Long artistId,
        Integer numberOfWords) {
}

