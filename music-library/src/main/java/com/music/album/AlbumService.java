package com.music.album;

import com.music.album.dto.AlbumRequestDto;
import com.music.album.dto.AlbumResponseDto;
import com.music.album.port.outbound.AlbumRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class AlbumService {
    private final AlbumRepository albumRepository;

    List<AlbumResponseDto> getAll()
    {
        return albumRepository.getAll();
    }

    AlbumResponseDto add(AlbumRequestDto albumRequestDto)
    {
        return albumRepository.add(albumRequestDto);
    }
}
