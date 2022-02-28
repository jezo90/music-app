package com.music.quiz.dao;

import com.music.quiz.dto.QuizResponseDto;
import com.music.track.dao.TrackEntity;
import com.music.user.dao.UserEntity;

import java.util.Objects;

public class QuizEntityMapper {

    public static QuizResponseDto map(QuizEntity quizEntity) {
        return new QuizResponseDto(
                quizEntity.getUserEntity().getId(),
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

    public static QuizEntity map(QuizSaveDto quizSaveDto) {
        QuizEntity quizEntity = new QuizEntity();

        UserEntity userEntity = new UserEntity();
        userEntity.setId(quizSaveDto.userId());

        TrackEntity firstTrackEntity = new TrackEntity();
        firstTrackEntity.setId(quizSaveDto.firstTrackId());

        TrackEntity secondTrackEntity = new TrackEntity();
        secondTrackEntity.setId(quizSaveDto.secondTrackId());

        TrackEntity thirdTrackEntity = new TrackEntity();
        thirdTrackEntity.setId(quizSaveDto.thirdTrackId());

        quizEntity.setUserEntity(userEntity);
        quizEntity.setTrackEntity1(firstTrackEntity);
        quizEntity.setTrackEntity2(secondTrackEntity);
        quizEntity.setTrackEntity3(thirdTrackEntity);
        quizEntity.setWords(quizSaveDto.words());
        quizEntity.setCorrectAnswer(quizSaveDto.correctAnswerId());
        quizEntity.setChosenAnswer(quizSaveDto.chosenAnswerId());
        if (Objects.equals(quizSaveDto.chosenAnswerId(), quizSaveDto.correctAnswerId()))
            quizEntity.setScore(1);
        else
            quizEntity.setScore(0);

        return quizEntity;
    }

}
