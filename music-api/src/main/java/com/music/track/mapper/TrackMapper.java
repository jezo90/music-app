package com.music.track.mapper;

import com.music.track.dto.TrackRequestDto;
import com.music.track.dto.TrackResponseDto;
import com.music.track.model.TrackRequest;
import com.music.track.model.TrackResponse;

public class TrackMapper {
    public static TrackResponse map(TrackResponseDto trackResponseDto) {
        return new TrackResponse(
                trackResponseDto.title(),
                trackResponseDto.text(),
                trackResponseDto.feat()
        );
    }

    public static TrackRequestDto map(TrackRequest trackRequest) {
        return new TrackRequestDto(
                trackRequest.title(),
                trackRequest.text(),
                trackRequest.feat(),
                trackRequest.albumId()
        );
    }
}
