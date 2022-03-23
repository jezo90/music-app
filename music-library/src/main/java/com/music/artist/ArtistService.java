package com.music.artist;

import com.music.artist.dto.ArtistImageDto;
import com.music.artist.dto.ArtistRequestDto;
import com.music.artist.dto.ArtistResponseDto;
import com.music.artist.port.outbound.ArtistRepository;
import com.music.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
class ArtistService {
    private final ArtistRepository artistRepository;

    public List<ArtistResponseDto> getAll() {
        return artistRepository.getAll();
    }

    public ArtistResponseDto get(Long id) {
        return artistRepository
                .getOptional(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no artist with such Id "));
    }

    public ArtistResponseDto add(ArtistRequestDto artistRequestDto) throws IOException {

        return artistRepository.add(artistRequestDto);
    }

    public ArtistImageDto findImageByName(String name) {
        return artistRepository.findImageByName(name)
                .orElseThrow(() -> new EntityNotFoundException("There is no artist with such Id "));
    }

}
