package com.music.quiz.mapper;

import com.music.quiz.dto.QuizRequestDto;
import com.music.quiz.dto.QuizResponseDto;
import com.music.quiz.model.QuizRequest;
import com.music.quiz.model.QuizResponse;

public class QuizMapper {

    public static QuizRequestDto map(QuizRequest quizRequest)
    {
        return new QuizRequestDto(
                quizRequest.getAlbum_id(),
                quizRequest.getArtist_id(),
                quizRequest.getNumberOfWords()
        );
    }

    public static QuizResponse map(QuizResponseDto quizResponseDto)
    {
        return new QuizResponse(
                quizResponseDto.quiz_id(),
                quizResponseDto.track1_title(),
                quizResponseDto.track1_id(),
                quizResponseDto.track2_title(),
                quizResponseDto.track2_id(),
                quizResponseDto.track3_title(),
                quizResponseDto.track3_id(),
                quizResponseDto.words());
    }
}
