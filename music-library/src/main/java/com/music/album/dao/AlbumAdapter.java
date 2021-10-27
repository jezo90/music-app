package com.music.album.dao;

import com.music.album.dto.AlbumRequestDto;
import com.music.album.dto.AlbumResponseDto;
import com.music.album.port.outbound.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


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
    public AlbumResponseDto add(AlbumRequestDto albumRequestDto) {
        return AlbumEntityMapper.map(
                albumSpringRepository.save(
                        AlbumEntityMapper
                                .map(albumRequestDto)));
    }
}
