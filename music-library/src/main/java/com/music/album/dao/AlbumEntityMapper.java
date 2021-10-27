package com.music.album.dao;

import com.music.album.dto.AlbumRequestDto;
import com.music.album.dto.AlbumResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumEntityMapper {
    public static AlbumResponseDto map(AlbumEntity albumEntity)
    {
        return new AlbumResponseDto(
                albumEntity.getId(),
                albumEntity.getCdName(),
                albumEntity.getReleaseDate());
    }
    public static List<AlbumResponseDto> map(List<AlbumEntity> albumEntityList)
    {
        return albumEntityList
                .stream()
                .map(AlbumEntityMapper::map)
                .collect(Collectors.toList());
    }

    public static AlbumEntity map(AlbumRequestDto albumRequestDto)
    {
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setCdName(albumRequestDto.getCdName());
        albumEntity.setReleaseDate(albumRequestDto.getReleaseDate());

        return albumEntity;
    }

}
