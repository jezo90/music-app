package com.music.track.dao;


import com.music.track.dto.TrackRequestDto;
import com.music.track.dto.TrackResponseDto;
import com.music.track.port.outbound.TrackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class TrackAdapter implements TrackRepository {

    private final TrackSpringRepository trackSpringRepository;

    @Override
    public Optional<TrackResponseDto> get(Long id) {
        return trackSpringRepository
                .findById(id)
                .map(TrackEntityMapper::map);
    }

    @Override
    public TrackResponseDto add(TrackRequestDto trackRequestDto) {
        return TrackEntityMapper
                .map(
                        trackSpringRepository
                                .save(
                                        TrackEntityMapper.map(
                                                trackRequestDto)));
    }
}
