package com.music.quiz.port.inbound;

import com.music.quiz.dto.AnswerRequestDto;
import com.music.quiz.dto.QuizRequestDto;
import com.music.quiz.dto.QuizResponseDto;

public interface QuizComponent {
    QuizResponseDto createQuiz(QuizRequestDto quizRequestDto);
    QuizResponseDto updateAnswer(AnswerRequestDto answerRequestDto);
}
