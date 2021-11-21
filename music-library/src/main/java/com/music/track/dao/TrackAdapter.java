package com.music.track.dao;


import com.music.track.port.outbound.TrackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
class TrackAdapter implements TrackRepository {

    private final TrackSpringRepository trackSpringRepository;

}
