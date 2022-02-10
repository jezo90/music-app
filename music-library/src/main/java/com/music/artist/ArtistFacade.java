package com.music.artist;

import com.music.artist.dto.ArtistRequestDto;
import com.music.artist.dto.ArtistResponseDto;
import com.music.artist.port.inbound.ArtistComponent;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class ArtistFacade implements ArtistComponent {
    private final ArtistService artistService;

    @Override
    public List<ArtistResponseDto> getAll() {
        return artistService.getAll();
    }

    @Override
    public ArtistResponseDto get(Long id) {
        return artistService.get(id);
    }

    @Override
    public ArtistResponseDto add(ArtistRequestDto artistRequestDto) {
        return artistService.add(artistRequestDto);
    }

    @Override
    public List<ArtistResponseDto> addMultiple(List<ArtistRequestDto> artistRequestDtoList) {
        return artistService.addMultiple(artistRequestDtoList);
    }

}