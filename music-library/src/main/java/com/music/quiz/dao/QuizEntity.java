package com.music.quiz.dao;

import com.music.track.dao.TrackEntity;
import com.music.user.dao.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "quiz")
@NoArgsConstructor
public class QuizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "track1_id")
    private TrackEntity trackEntity1;

    @ManyToOne
    @JoinColumn(name = "track2_id")
    private TrackEntity trackEntity2;

    @ManyToOne
    @JoinColumn(name = "track3_id")
    private TrackEntity trackEntity3;

    private String words;

    private Long correctAnswer;

    private Long chosenAnswer;

    private int score;

}

