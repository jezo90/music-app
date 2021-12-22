package com.music.track;

import com.music.exception.EntityNotFoundException;
import com.music.track.dto.TrackRequestDto;
import com.music.track.dto.TrackResponseDto;
import com.music.track.port.outbound.TrackRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

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
                trackRequestDto.getTitle(),
                trackRequestDto.getText().replaceAll("\\n", " "),
                trackRequestDto.getFeat(),
                trackRequestDto.getAlbum_id());

        return trackRepository.add(trackRequestDtoRemovedLinebreaks);
    }

}
