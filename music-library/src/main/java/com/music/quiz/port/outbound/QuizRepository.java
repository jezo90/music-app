package com.music.quiz.port.outbound;

import com.music.quiz.dao.QuizEntity;
import com.music.quiz.dto.AnswerRequestDto;
import com.music.quiz.dto.QuizCreateDto;
import com.music.quiz.dto.QuizResponseDto;

public interface QuizRepository {
    Long createQuiz(QuizCreateDto quizCreateDto);
    QuizResponseDto updateAnswer(QuizEntity quizEntity);
    QuizResponseDto getById(Long id);
    QuizEntity getQuizEntity(Long id);
}
