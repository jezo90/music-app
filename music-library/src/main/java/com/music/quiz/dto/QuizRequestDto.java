package com.music.quiz.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class QuizRequestDto {
    private final Long album_id;
    private final Long artist_id;
    private final int numberOfWords;
}

