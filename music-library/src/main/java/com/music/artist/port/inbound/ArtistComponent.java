package com.music.artist.port.inbound;

import com.music.artist.dto.ArtistImageDto;
import com.music.artist.dto.ArtistRequestDto;
import com.music.artist.dto.ArtistResponseDto;

import java.util.List;

public interface ArtistComponent {
    List<ArtistResponseDto> getAll();

    ArtistResponseDto get(Long id);

    Long add(ArtistRequestDto artistRequestDto);

    ArtistImageDto findImageByName(String name);
}
