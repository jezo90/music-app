package com.music.artist.dao;

import com.music.album.dto.AlbumImageDto;
import com.music.album.dto.TrackDetailsDto;
import com.music.artist.dto.ArtistImageDto;
import com.music.artist.dto.ArtistRequestDto;
import com.music.artist.dto.ArtistResponseDto;
import com.music.artist.port.outbound.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
class ArtistAdapter implements ArtistRepository {
    private final ArtistSpringRepository artistSpringRepository;

    @Override
    public List<ArtistResponseDto> getAll() {

        return artistSpringRepository
                .findAll()
                .stream()
                .map(ArtistEntityMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ArtistResponseDto> getOptional(Long id) {
        return artistSpringRepository
                .findById(id)
                .map(ArtistEntityMapper::map);
    }

    @Override
    public Long add(ArtistRequestDto artistRequestDto){

       ArtistEntity artistEntity = artistSpringRepository.saveAndFlush(
                                    ArtistEntityMapper.map(artistRequestDto));

        return artistEntity.getId();
    }

    @Override
    public List<TrackDetailsDto> getArtistTrackList(Long id) {
        return artistSpringRepository.
                getById(id).getAlbumList()
                .stream()
                .flatMap(albumEntity -> albumEntity.getTrackList()
                        .stream()
                        .map(trackEntity -> new TrackDetailsDto(
                                trackEntity.getId(),
                                trackEntity.getTitle(),
                                trackEntity.getText()
                        )))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ArtistImageDto> findImageByName(String name) {
        return artistSpringRepository
                .findArtistEntitiesByImageName(name).stream().findFirst()
                .map(ArtistEntityMapper::mapToImageDto);
    }
}
