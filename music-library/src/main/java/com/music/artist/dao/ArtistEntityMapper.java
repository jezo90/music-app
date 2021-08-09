package com.music.artist.dao;

import com.music.artist.dto.ArtistRequestDto;
import com.music.artist.dto.ArtistResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class ArtistEntityMapper {

    public static ArtistResponseDto map(ArtistEntity artistEntity)
    {
        return new ArtistResponseDto(artistEntity.getId(), artistEntity.getName());
    }

    public static List<ArtistResponseDto> map(List<ArtistEntity> artistEntities)
    {
        return artistEntities.stream()
                .map(ArtistEntityMapper::map)
                .collect(Collectors.toList());

    }

    public static ArtistEntity map(ArtistRequestDto artistRequestDto)
    {
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setName(artistRequestDto.getName());

        return artistEntity;
    }

    public static List<ArtistEntity> mapToEntity(List<ArtistRequestDto> artistRequestDtoList)
    {
        return artistRequestDtoList
                .stream()
                .map(ArtistEntityMapper::map)
                .collect(Collectors.toList());
    }

}
