package com.music.album.port.outbound;

import com.music.album.dto.AlbumRequestDto;
import com.music.album.dto.AlbumResponseDto;

import java.util.List;

public interface AlbumRepository {
    List<AlbumResponseDto> getAll();
    AlbumResponseDto add(AlbumRequestDto albumRequestDto);
}
