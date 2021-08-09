package com.music.artist.dao;

import com.music.artist.dto.ArtistDto;

import java.util.List;
import java.util.stream.Collectors;

public class ArtistEntityMapper {

    public static ArtistDto map(ArtistEntity artistEntity)
    {
        return new ArtistDto(artistEntity.getName());
    }

    public static List<ArtistDto> map(List<ArtistEntity> artistEntities)
    {
        return artistEntities.stream()
                .map(ArtistEntityMapper::map)
                .collect(Collectors.toList());

    }

    public static ArtistEntity map(ArtistDto artistDto)
    {
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setName(artistDto.getName());

        return artistEntity;
    }

}
