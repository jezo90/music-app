package com.music.quiz.port.inbound;

import com.music.quiz.dao.QuizSaveDto;
import com.music.quiz.dto.AnswerRequestDto;
import com.music.quiz.dto.QuizCreateDto;
import com.music.quiz.dto.QuizRequestDto;
import com.music.quiz.dto.QuizResponseDto;

public interface QuizComponent {
    QuizCreateDto createQuiz(QuizRequestDto quizRequestDto);
    QuizResponseDto getById(Long id);
    Long addQuiz(QuizSaveDto quizSaveDto);
}
