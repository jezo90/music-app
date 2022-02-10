package com.music.album;

import com.music.album.port.outbound.AlbumRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AlbumConfig {

    @Bean
    AlbumFacade albumFacade(AlbumRepository albumRepository) {
        AlbumService albumService = new AlbumService(albumRepository);
        return new AlbumFacade(albumService);
    }
}
