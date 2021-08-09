package com.music.artist.port.outbound;

import com.music.artist.dto.ArtistRequestDto;
import com.music.artist.dto.ArtistResponseDto;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository {
    List<ArtistResponseDto> getAll();

    Optional<ArtistResponseDto> getOptional(Long id);

    ArtistResponseDto add(ArtistRequestDto artistRequestDto);

    List<ArtistResponseDto> addMultiple(List<ArtistRequestDto> artistRequestDtoList);
}
