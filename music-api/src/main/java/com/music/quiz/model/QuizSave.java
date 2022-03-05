package com.music.quiz.model;

public record QuizSave(
        String username,
        Long firstTrackId,
        Long secondTrackId,
        Long thirdTrackId,
        String words,
        Long correctAnswerId,
        Long chosenAnswerId
        ) {
}
