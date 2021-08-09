package com.music.artist;

import com.music.artist.dao.ArtistEntityMapper;
import com.music.artist.dao.ArtistSpringRepository;
import com.music.artist.dto.ArtistDto;
import com.music.artist.port.outbound.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
class ArtistAdapter implements ArtistRepository {

    private final ArtistSpringRepository artistSpringRepository;

    @Override
    public List<ArtistDto> getAllArtists() {

        return artistSpringRepository
                .findAll()
                .stream()
                .map(ArtistEntityMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ArtistDto> getOptionalArtist(Long id) {
        return artistSpringRepository
                .findById(id)
                .map(ArtistEntityMapper::map);
    }

    @Override
    public ArtistDto addArtist(ArtistDto artistDto) {
        return ArtistEntityMapper.map(
                artistSpringRepository
                        .save(ArtistEntityMapper
                                .map(artistDto)));
    }
}
