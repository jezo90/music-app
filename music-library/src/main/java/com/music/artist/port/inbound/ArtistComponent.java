package com.music.artist.port.inbound;

import com.music.artist.dto.ArtistRequestDto;
import com.music.artist.dto.ArtistResponseDto;

import java.io.IOException;
import java.util.List;

public interface ArtistComponent {
    List<ArtistResponseDto> getAll();
    ArtistResponseDto get(Long id);
    ArtistResponseDto add(ArtistRequestDto artistRequestDto) throws IOException;
}
