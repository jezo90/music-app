package com.music.quiz.mapper;

import com.music.quiz.dto.QuizRequestDto;
import com.music.quiz.dto.QuizResponseDto;
import com.music.quiz.model.QuizRequest;
import com.music.quiz.model.QuizResponse;

public class QuizMapper {

    public static QuizRequestDto map(QuizRequest quizRequest)
    {
        return new QuizRequestDto(
                quizRequest.album_id(),
                quizRequest.artist_id(),
                quizRequest.numberOfWords()
        );
    }

    public static QuizResponse map(QuizResponseDto quizResponseDto)
    {
        return new QuizResponse(
                quizResponseDto.quiz_id(),
                quizResponseDto.firstTrackTitle(),
                quizResponseDto.firstTrackId(),
                quizResponseDto.secondTrackTitle(),
                quizResponseDto.secondTrackId(),
                quizResponseDto.secondTrackTitle(),
                quizResponseDto.secondTrackId(),
                quizResponseDto.words());
    }
}
