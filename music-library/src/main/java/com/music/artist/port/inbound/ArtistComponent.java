package com.music.artist.port.inbound;

import com.music.artist.dto.ArtistDto;

import java.util.List;

public interface ArtistComponent {

    List<ArtistDto> getAllArtists();

    ArtistDto getArtist(Long id);

    ArtistDto addArtist(ArtistDto artistDto);

}
