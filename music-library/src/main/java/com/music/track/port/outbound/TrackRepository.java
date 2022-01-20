package com.music.track.port.outbound;


import com.music.track.dto.TrackRequestDto;
import com.music.track.dto.TrackResponseDto;

import java.util.Optional;

public interface TrackRepository {
    Optional<TrackResponseDto> get(Long id);
    TrackResponseDto add(TrackRequestDto trackRequestDto);
}
