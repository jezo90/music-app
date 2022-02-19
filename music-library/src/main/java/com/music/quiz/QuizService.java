package com.music.quiz;

import com.music.album.dto.TrackDetailsDto;
import com.music.album.port.outbound.AlbumRepository;
import com.music.artist.port.outbound.ArtistRepository;
import com.music.quiz.dao.QuizEntity;
import com.music.quiz.dto.AnswerRequestDto;
import com.music.quiz.dto.QuizCreateDto;
import com.music.quiz.dto.QuizRequestDto;
import com.music.quiz.dto.QuizResponseDto;
import com.music.quiz.port.outbound.QuizRepository;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
class QuizService {
    private final QuizRepository quizRepository;
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

    public QuizResponseDto createQuiz(QuizRequestDto quizRequestDto) {

        Random random = new Random();
        int randomTrack = random.nextInt(3);
        List<TrackDetailsDto> trackList;

        if (quizRequestDto.albumId() != null) {
            trackList = albumRepository.getTrackList(quizRequestDto.albumId());
        } else {
            trackList = artistRepository.getArtistTrackList(quizRequestDto.artistId());
        }
        Collections.shuffle(trackList);

        TrackDetailsDto chosenTrack = trackList.get(randomTrack);

        QuizCreateDto quizCreateDto = new QuizCreateDto(
                quizRequestDto.userId(),
                trackList.get(0).id(),
                trackList.get(1).id(),
                trackList.get(2).id(),
                getWords(chosenTrack, random, quizRequestDto.numberOfWords()),
                chosenTrack.id()
        );


        return quizRepository.createQuiz(quizCreateDto);
    }

    private String getWords(TrackDetailsDto trackDetailsDto, Random random, int numberOfWords) {
        String[] words = trackDetailsDto.text().split("\\s");
        StringBuilder chosenText = new StringBuilder();
        int randomWord = random.nextInt(words.length - numberOfWords - 1);
        for (int i = randomWord; i < randomWord + numberOfWords; i++) {
            chosenText.append(words[i]).append(" ");
        }
        return chosenText.toString();
    }

    public QuizResponseDto updateAnswer(AnswerRequestDto answerRequestDto) {

        QuizEntity quiz = quizRepository.getQuizEntity(answerRequestDto.quizId());
        quiz.setChosenAnswer(answerRequestDto.userAnswer());

        return quizRepository.updateAnswer(quiz);
    }

}
