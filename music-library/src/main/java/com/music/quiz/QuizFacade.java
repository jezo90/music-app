package com.music.quiz;

import com.music.quiz.dto.QuizRequestDto;
import com.music.quiz.dto.QuizResponseDto;
import com.music.quiz.port.inbound.QuizComponent;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class QuizFacade implements QuizComponent {

    private final QuizService quizService;

    @Override
    public QuizResponseDto createQuiz(QuizRequestDto quizRequestDto) {
        return quizService.createQuiz(quizRequestDto);
    }
}
