package com.music.quiz.mapper;

import com.music.quiz.dao.QuizSaveDto;
import com.music.quiz.dto.QuizCreateDto;
import com.music.quiz.dto.QuizRequestDto;
import com.music.quiz.dto.QuizResponseDto;
import com.music.quiz.model.QuizCreate;
import com.music.quiz.model.QuizRequest;
import com.music.quiz.model.QuizResponse;
import com.music.quiz.model.QuizSave;

public class QuizMapper {
    public static QuizRequestDto map(QuizRequest quizRequest) {
        return new QuizRequestDto(
                quizRequest.albumId(),
                quizRequest.artistId(),
                quizRequest.numberOfWords()
        );
    }

    public static QuizResponse map(QuizResponseDto quizResponseDto) {
        return new QuizResponse(
                quizResponseDto.userId(),
                quizResponseDto.firstTrackId(),
                quizResponseDto.firstTrackTitle(),
                quizResponseDto.secondTrackId(),
                quizResponseDto.secondTrackTitle(),
                quizResponseDto.thirdTrackId(),
                quizResponseDto.thirdTrackTitle(),
                quizResponseDto.words(),
                quizResponseDto.correctAnswerId(),
                quizResponseDto.userAnswerId()
        );
    }


    public static QuizCreate map(QuizCreateDto quizCreateDto)
    {
        return new QuizCreate(
                quizCreateDto.firstTrackId(),
                quizCreateDto.firstTrackTitle(),
                quizCreateDto.secondTrackId(),
                quizCreateDto.secondTrackTitle(),
                quizCreateDto.thirdTrackId(),
                quizCreateDto.thirdTrackTitle(),
                quizCreateDto.words(),
                quizCreateDto.correctAnswerId()
        );
    }

    public static QuizSaveDto map(QuizSave quizSave)
    {
        return new QuizSaveDto(
                quizSave.userId(),
                quizSave.firstTrackId(),
                quizSave.secondTrackId(),
                quizSave.thirdTrackId(),
                quizSave.words(),
                quizSave.correctAnswerId(),
                quizSave.chosenAnswerId()
        );
    }


}
