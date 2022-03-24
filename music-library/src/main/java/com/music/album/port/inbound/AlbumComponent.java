package com.music.album.port.inbound;

import com.music.album.dto.AlbumDetailsResponseDto;
import com.music.album.dto.AlbumImageDto;
import com.music.album.dto.AlbumRequestDto;
import com.music.album.dto.AlbumResponseDto;

import java.io.IOException;
import java.util.List;

public interface AlbumComponent {
    List<AlbumResponseDto> getAll();
    AlbumResponseDto add(AlbumRequestDto albumRequestDto) throws IOException;
    AlbumDetailsResponseDto get(Long id);
    List<AlbumDetailsResponseDto> getByArtistId(Long id);
    AlbumImageDto findImageByName(String name);
}
