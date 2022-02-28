package com.music.quiz.port.outbound;

import com.music.quiz.dao.QuizEntity;
import com.music.quiz.dao.QuizSaveDto;
import com.music.quiz.dto.QuizResponseDto;

public interface QuizRepository {

    QuizResponseDto getById(Long id);

    QuizEntity getQuizEntity(Long id);

    Long addQuiz(QuizSaveDto quizSaveDto);
}
