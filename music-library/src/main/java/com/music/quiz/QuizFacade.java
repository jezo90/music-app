package com.music.quiz;

import com.music.quiz.dto.AnswerRequestDto;
import com.music.quiz.dto.QuizRequestDto;
import com.music.quiz.dto.QuizResponseDto;
import com.music.quiz.port.inbound.QuizComponent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class QuizFacade implements QuizComponent {
    private final QuizService quizService;

    @Override
    public QuizResponseDto createQuiz(QuizRequestDto quizRequestDto) {
        return quizService.createQuiz(quizRequestDto);
    }

    @Override
    public QuizResponseDto updateAnswer(AnswerRequestDto answerRequestDto) {
        return quizService.updateAnswer(answerRequestDto);
    }
}
