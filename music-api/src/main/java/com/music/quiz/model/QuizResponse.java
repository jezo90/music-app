package com.music.quiz.model;

public record QuizResponse(
        Long userId,
        Long firstTrackId,
        String firstTrackTitle,
        Long secondTrackId,
        String secondTrackTitle,
        Long thirdTrackId,
        String thirdTrackTitle,
        String words,
        Long correctAnswerId,
        Long userAnswerId
) {
}
