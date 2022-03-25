package com.music.album.port.outbound;

import com.music.album.dto.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface AlbumRepository {
    List<AlbumResponseDto> getAll();

    Long add(AlbumRequestDto albumRequestDto) throws IOException;

    Optional<AlbumDetailsResponseDto> getOptional(Long id);

    List<TrackDetailsDto> getTrackList(Long id);

    List<AlbumDetailsResponseDto> getByArtistId(Long id);

    Optional<AlbumImageDto> findImageByName(String name);
}
