package com.music.artist;

import com.music.artist.port.outbound.ArtistRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ArtistConfig {

    @Bean
    ArtistFacade artistFacade(ArtistRepository artistRepository) {
        ArtistService artistService = new ArtistService(artistRepository);
        return new ArtistFacade(artistService);
    }
}
