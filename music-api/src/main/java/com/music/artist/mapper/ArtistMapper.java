package com.music.artist.mapper;

import com.music.artist.dto.ArtistDto;
import com.music.artist.model.ArtistResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ArtistMapper {

    public static ArtistResponse map(ArtistDto artistDto)
    {
        return new ArtistResponse(artistDto.getName());
    }

    public static List<ArtistResponse> map(List<ArtistDto> artistDtos)
    {
        return artistDtos
                .stream()
                .map(ArtistMapper::map)
                .collect(Collectors.toList());
    }

    public static ArtistDto map(ArtistResponse artistResponse)
    {
        return new ArtistDto(artistResponse.getName());
    }
}
