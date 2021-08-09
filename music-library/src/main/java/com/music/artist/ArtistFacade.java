package com.music.artist;

import com.music.artist.dto.ArtistDto;
import com.music.artist.port.inbound.ArtistComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
class ArtistFacade implements ArtistComponent {

    private final ArtistService artistService;

    @Override
    public List<ArtistDto> getAllArtists() {

        return artistService.getAllArtists();
    }

    @Override
    public ArtistDto getArtist(Long id) {
        return artistService.getArtist(id);
    }

    @Override
    public ArtistDto addArtist(ArtistDto artistDto) {
        return artistService.addArtist(artistDto);
    }

}