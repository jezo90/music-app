package com.music.track;

import com.music.track.port.outbound.TrackRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TrackConfig {

    @Bean
    TrackFacade trackFacade(TrackRepository trackRepository)
    {
        TrackService trackService = new TrackService(trackRepository);
        return new TrackFacade(trackService);
    }
}
