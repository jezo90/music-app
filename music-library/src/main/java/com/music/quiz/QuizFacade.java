package com.music.quiz;

import com.music.quiz.dao.QuizSaveDto;
import com.music.quiz.dto.QuizCreateDto;
import com.music.quiz.dto.QuizRequestDto;
import com.music.quiz.dto.QuizResponseDto;
import com.music.quiz.port.inbound.QuizComponent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class QuizFacade implements QuizComponent {
    private final QuizService quizService;

    @Override
    public QuizCreateDto createQuiz(QuizRequestDto quizRequestDto) {

        return quizService.createQuiz(quizRequestDto);
    }

    @Override
    public QuizResponseDto getById(Long id) {
        return quizService.getById(id);
    }

    @Override
    public Long addQuiz(QuizSaveDto quizSaveDto) {
        return quizService.addQuiz(quizSaveDto);
    }
}
