package com.music.artist.dao;

import com.music.album.dto.TrackDetailsDto;
import com.music.artist.dto.ArtistRequestDto;
import com.music.artist.dto.ArtistResponseDto;
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
    public ArtistResponseDto add(ArtistRequestDto artistRequestDto) {
        return ArtistEntityMapper.map(
                artistSpringRepository
                        .save(ArtistEntityMapper
                                      .map(artistRequestDto)));
    }

    @Override
    public List<ArtistResponseDto> addMultiple(List<ArtistRequestDto> artistRequestDtoList) {
        return ArtistEntityMapper.map(
                artistSpringRepository
                        .saveAll(ArtistEntityMapper
                                         .mapToEntity(artistRequestDtoList)));
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
}
