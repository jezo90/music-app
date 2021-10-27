package com.music.album.dao;

import com.music.album.dto.AlbumDetailsResponseDto;
import com.music.album.dto.AlbumRequestDto;
import com.music.album.dto.AlbumResponseDto;
import com.music.album.port.outbound.AlbumRepository;
import com.music.artist.dao.ArtistEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Component
@RequiredArgsConstructor
class AlbumAdapter implements AlbumRepository {

    private final AlbumSpringRepository albumSpringRepository;


    @Override
    public List<AlbumResponseDto> getAll() {
        return AlbumEntityMapper.map(
                albumSpringRepository.findAll());
    }

    @Override
    @Transactional
    public AlbumResponseDto add(AlbumRequestDto albumRequestDto) {
        return AlbumEntityMapper.map(
                albumSpringRepository.saveAndFlush(
                        AlbumEntityMapper
                                .map(albumRequestDto)));
    }

    @Override
    public Optional<AlbumDetailsResponseDto> getOptional(Long id) {
        return albumSpringRepository.findById(id)
                .map(AlbumEntityMapper::mapToDetails);
    }
}
