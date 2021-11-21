package com.music.track;

import com.music.exception.EntityNotFoundException;
import com.music.track.dto.TrackRequestDto;
import com.music.track.dto.TrackResponseDto;
import com.music.track.port.outbound.TrackRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class TrackService {

    private final TrackRepository artistRepository;

}
