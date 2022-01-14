package com.music.quiz.port.outbound;

import com.music.quiz.dto.QuizCreateDto;
import com.music.quiz.dto.QuizRequestDto;
import com.music.quiz.dto.QuizResponseDto;

import java.util.List;
import java.util.Optional;

public interface QuizRepository {
    QuizResponseDto createQuiz(QuizCreateDto quizCreateDto);

}
