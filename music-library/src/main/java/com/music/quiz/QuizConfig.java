package com.music.quiz;

import com.music.album.port.outbound.AlbumRepository;
import com.music.artist.port.outbound.ArtistRepository;
import com.music.quiz.port.outbound.QuizRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class QuizConfig {

    @Bean
    QuizFacade quizFacade(QuizRepository quizRepository, AlbumRepository albumRepository, ArtistRepository artistRepository) {
        QuizService quizService = new QuizService(quizRepository, albumRepository, artistRepository);
        return new QuizFacade(quizService);
    }
}
