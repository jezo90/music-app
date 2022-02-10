package com.music.quiz.dao;

import com.music.quiz.dto.QuizCreateDto;
import com.music.quiz.dto.QuizResponseDto;
import com.music.track.dao.TrackEntity;


public class QuizEntityMapper {

    public static QuizEntity map(QuizCreateDto quizCreateDto) {
        QuizEntity quizEntity = new QuizEntity();
        TrackEntity trackEntity1 = new TrackEntity();
        trackEntity1.setId(quizCreateDto.firstTrackEntity());

        TrackEntity trackEntity2 = new TrackEntity();
        trackEntity2.setId(quizCreateDto.secondTrackEntity());

        TrackEntity trackEntity3 = new TrackEntity();
        trackEntity3.setId(quizCreateDto.thirdTrackEntity());

        quizEntity.setTrackEntity1(trackEntity1);
        quizEntity.setTrackEntity2(trackEntity2);
        quizEntity.setTrackEntity3(trackEntity3);
        quizEntity.setWords(quizCreateDto.words());
        quizEntity.setCorrectAnswer(quizCreateDto.correctAnswer());
        quizEntity.setChosenAnswer(0L);
        quizEntity.setScore(0);

        return quizEntity;
    }

    public static QuizResponseDto map(QuizEntity quizEntity) {
        return new QuizResponseDto(
                quizEntity.getId(),
                quizEntity.getTrackEntity1().getTitle(),
                quizEntity.getTrackEntity1().getId(),
                quizEntity.getTrackEntity2().getTitle(),
                quizEntity.getTrackEntity2().getId(),
                quizEntity.getTrackEntity3().getTitle(),
                quizEntity.getTrackEntity3().getId(),
                quizEntity.getWords()
        );
    }

}
