package com.music.artist.dao;

import com.music.artist.dto.ArtistRequestDto;
import com.music.artist.dto.ArtistResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class ArtistEntityMapper {

    public static ArtistResponseDto map(ArtistEntity artistEntity)
    {
        return new ArtistResponseDto(
                artistEntity.getId(),
                artistEntity.getNickname(),
                artistEntity.getFirstName(),
                artistEntity.getLastName(),
                artistEntity.getBirthDate());
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
        artistEntity.setNickname(artistRequestDto.getNickname());
        artistEntity.setFirstName(artistRequestDto.getFirstName());
        artistEntity.setLastName(artistRequestDto.getLastName());
        artistEntity.setBirthDate(artistRequestDto.getBirthDate());

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
