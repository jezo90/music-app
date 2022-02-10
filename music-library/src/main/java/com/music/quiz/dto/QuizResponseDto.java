package com.music.quiz.dto;


public record QuizResponseDto(
        Long quizId,
        String firstTrackTitle,
        Long firstTrackId,
        String secondTrackTitle,
        Long secondTrackId,
        String thirdTrackTitle,
        Long thirdTrackId,
        String words
) {
}

