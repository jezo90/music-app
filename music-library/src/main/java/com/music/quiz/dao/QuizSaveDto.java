package com.music.quiz.dao;

public record QuizSaveDto(
        String username,
        Long firstTrackId,
        Long secondTrackId,
        Long thirdTrackId,
        String words,
        Long correctAnswerId,
        Long chosenAnswerId
) {
}
