package com.music.quiz.model;

public record QuizSave(
        Long userId,
        Long firstTrackId,
        Long secondTrackId,
        Long thirdTrackId,
        String words,
        Long correctAnswerId,
        Long chosenAnswerId
        ) {
}
