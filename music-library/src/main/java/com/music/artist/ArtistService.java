package com.music.artist;

import com.music.artist.dto.ArtistDto;
import com.music.artist.port.outbound.ArtistRepository;
import com.music.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class ArtistService {

    private final ArtistRepository artistRepository;

    public List<ArtistDto> getAllArtists()
    {
        return artistRepository.getAllArtists();
    }

    public ArtistDto getArtist(Long id)
    {
        return artistRepository
                .getOptionalArtist(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no artist with such Id "));
    }

    public ArtistDto addArtist(ArtistDto artistDto)
    {
        return artistRepository.addArtist(artistDto);
    }

}
