package com.music.quiz.model;

public record QuizResponse(
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
