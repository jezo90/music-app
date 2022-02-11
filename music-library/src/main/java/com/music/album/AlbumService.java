package com.music.album;

import com.music.album.dto.AlbumDetailsResponseDto;
import com.music.album.dto.AlbumRequestDto;
import com.music.album.dto.AlbumResponseDto;
import com.music.album.port.outbound.AlbumRepository;
import com.music.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class AlbumService {
    private final AlbumRepository albumRepository;

    List<AlbumResponseDto> getAll() {
        return albumRepository.getAll();
    }

    AlbumResponseDto add(AlbumRequestDto albumRequestDto) {
        return albumRepository.add(albumRequestDto);
    }

    AlbumDetailsResponseDto get(Long id) {
        return albumRepository.getOptional(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no artist with such Id"));
    }

    List<AlbumDetailsResponseDto> getByArtistId(Long id)
    {
        return albumRepository.getByArtistId(id);
    }
}
