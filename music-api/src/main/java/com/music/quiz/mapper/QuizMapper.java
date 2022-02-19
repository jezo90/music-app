package com.music.quiz.mapper;

import com.music.quiz.dto.AnswerRequestDto;
import com.music.quiz.dto.QuizRequestDto;
import com.music.quiz.dto.QuizResponseDto;
import com.music.quiz.model.AnswerRequest;
import com.music.quiz.model.QuizRequest;
import com.music.quiz.model.QuizResponse;

public class QuizMapper {
    public static QuizRequestDto map(QuizRequest quizRequest) {
        return new QuizRequestDto(
                quizRequest.userId(),
                quizRequest.albumId(),
                quizRequest.artistId(),
                quizRequest.numberOfWords()
        );
    }

    public static QuizResponse map(QuizResponseDto quizResponseDto) {
        return new QuizResponse(
                quizResponseDto.userId(),
                quizResponseDto.quizId(),
                quizResponseDto.firstTrackTitle(),
                quizResponseDto.firstTrackId(),
                quizResponseDto.secondTrackTitle(),
                quizResponseDto.secondTrackId(),
                quizResponseDto.thirdTrackTitle(),
                quizResponseDto.thirdTrackId(),
                quizResponseDto.words()
        );
    }

    public static AnswerRequestDto map(AnswerRequest answerRequest)
    {
        return new AnswerRequestDto(
                answerRequest.quizId(),
                answerRequest.userId(),
                answerRequest.userAnswer()
        );
    }
}
