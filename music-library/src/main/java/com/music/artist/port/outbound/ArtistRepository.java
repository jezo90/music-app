package com.music.artist.port.outbound;

import com.music.album.dto.TrackDetailsDto;
import com.music.artist.dto.ArtistImageDto;
import com.music.artist.dto.ArtistRequestDto;
import com.music.artist.dto.ArtistResponseDto;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ArtistRepository {
    List<ArtistResponseDto> getAll();

    Optional<ArtistResponseDto> getOptional(Long id);

    ArtistResponseDto add(ArtistRequestDto artistRequestDto) throws IOException;

    List<TrackDetailsDto> getArtistTrackList(Long id);

    Optional<ArtistImageDto> findImageByName(String name);
}
