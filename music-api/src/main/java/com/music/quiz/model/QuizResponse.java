package com.music.quiz.model;

public record QuizResponse(
        Long quiz_id,
        String firstTrackTitle,
        Long firstTrackId,
        String secondTrackTitle,
        Long secondTrackId,
        String thirdTrackTitle,
        Long thirdTrackId,
        String words
) {
}
