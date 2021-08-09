package com.music.artist.port.outbound;

import com.music.artist.dto.ArtistDto;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository {
    List<ArtistDto> getAllArtists();

    Optional<ArtistDto> getOptionalArtist(Long id);

    ArtistDto addArtist(ArtistDto artistDto);
}
