package com.music.quiz.dto;


public record QuizResponseDto(
        Long quiz_id,
        String track1_title,
        Long track1_id,
        String track2_title,
        Long track2_id,
        String track3_title,
        Long track3_id,
        String words
) {
}

