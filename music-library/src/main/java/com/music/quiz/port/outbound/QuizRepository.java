package com.music.quiz.port.outbound;

import com.music.quiz.dto.QuizCreateDto;
import com.music.quiz.dto.QuizResponseDto;

public interface QuizRepository {
    QuizResponseDto createQuiz(QuizCreateDto quizCreateDto);
}
