package com.music.track;

import com.music.track.dto.TrackRequestDto;
import com.music.track.dto.TrackResponseDto;
import com.music.track.port.inbound.TrackComponent;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class TrackFacade implements TrackComponent {

    private final TrackService artistService;

}