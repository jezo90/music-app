package com.music.quiz.dao;

public record QuizSaveDto(
        Long userId,
        Long firstTrackId,
        Long secondTrackId,
        Long thirdTrackId,
        String words,
        Long correctAnswerId,
        Long chosenAnswerId
) {
}
