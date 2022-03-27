package com.music.album;

import com.music.album.dto.AlbumDetailsResponseDto;
import com.music.album.dto.AlbumImageDto;
import com.music.album.dto.AlbumRequestDto;
import com.music.album.dto.AlbumResponseDto;
import com.music.album.port.inbound.AlbumComponent;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
class AlbumFacade implements AlbumComponent {
    private final AlbumService albumService;

    public List<AlbumResponseDto> getAll() {
        return albumService.getAll();
    }

    public Long add(AlbumRequestDto albumRequestDto) {
        return albumService.add(albumRequestDto);
    }

    @Override
    public AlbumDetailsResponseDto get(Long id) {
        return albumService.get(id);
    }

    @Override
    public List<AlbumDetailsResponseDto> getByArtistId(Long id) {
        return albumService.getByArtistId(id);
    }

    @Override
    public AlbumImageDto findImageByName(String name) {
        return albumService.findImageByName(name);
    }


}
