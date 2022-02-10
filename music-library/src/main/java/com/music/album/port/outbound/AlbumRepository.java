package com.music.album.port.outbound;

import com.music.album.dto.AlbumDetailsResponseDto;
import com.music.album.dto.AlbumRequestDto;
import com.music.album.dto.AlbumResponseDto;
import com.music.album.dto.TrackDetailsDto;

import java.util.List;
import java.util.Optional;

public interface AlbumRepository {
    List<AlbumResponseDto> getAll();
    AlbumResponseDto add(AlbumRequestDto albumRequestDto);
    Optional<AlbumDetailsResponseDto> getOptional(Long id);
    List<TrackDetailsDto> getTrackList(Long id);
}
