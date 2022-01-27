package com.music.track;

import com.music.exception.EntityNotFoundException;
import com.music.track.dto.TrackRequestDto;
import com.music.track.dto.TrackResponseDto;
import com.music.track.port.outbound.TrackRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class TrackService {

    private final TrackRepository trackRepository;

    public TrackResponseDto get(Long id) {

        return trackRepository
                .get(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no track with such Id "));
    }

    public TrackResponseDto add(TrackRequestDto trackRequestDto)
    {
        TrackRequestDto trackRequestDtoRemovedLinebreaks = new TrackRequestDto(
                trackRequestDto.title(),
                trackRequestDto.text().replaceAll("\\n", " "),
                trackRequestDto.feat(),
                trackRequestDto.album_id());

        return trackRepository.add(trackRequestDtoRemovedLinebreaks);
    }

}
