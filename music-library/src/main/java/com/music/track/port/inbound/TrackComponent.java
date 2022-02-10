package com.music.track.port.inbound;

import com.music.track.dto.TrackRequestDto;
import com.music.track.dto.TrackResponseDto;

public interface TrackComponent {
    TrackResponseDto get(Long id);
    TrackResponseDto add(TrackRequestDto trackRequestDto);
}
