package com.music.track.mapper;

import com.music.track.dto.TrackRequestDto;
import com.music.track.dto.TrackResponseDto;
import com.music.track.model.TrackRequest;
import com.music.track.model.TrackResponse;

public class TrackMapper {
    public static TrackResponse map(TrackResponseDto trackResponseDto)
    {
        return new TrackResponse(
                trackResponseDto.getTitle(),
                trackResponseDto.getText(),
                trackResponseDto.getFeat()
        );
    }

    public static TrackRequestDto map(TrackRequest trackRequest)
    {
        return new TrackRequestDto(
                trackRequest.getTitle(),
                trackRequest.getText(),
                trackRequest.getFeat(),
                trackRequest.getAlbum_id()
        );
    }
}
