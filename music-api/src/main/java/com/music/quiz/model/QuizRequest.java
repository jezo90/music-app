package com.music.quiz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@AllArgsConstructor
public class QuizRequest {
    private Long album_id;
    private Long artist_id;
    private int numberOfWords;
}
