package com.music.album.port.inbound;

import com.music.album.dto.AlbumDetailsResponseDto;
import com.music.album.dto.AlbumRequestDto;
import com.music.album.dto.AlbumResponseDto;

import java.util.List;

public interface AlbumComponent {
    List<AlbumResponseDto> getAll();
    AlbumResponseDto add(AlbumRequestDto albumRequestDto);
    AlbumDetailsResponseDto get(Long id);
    List<AlbumDetailsResponseDto> getByArtistId(Long id);
}
