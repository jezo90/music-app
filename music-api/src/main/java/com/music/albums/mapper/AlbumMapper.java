package com.music.albums.mapper;

import com.music.album.dto.AlbumRequestDto;
import com.music.album.dto.AlbumResponseDto;
import com.music.albums.model.AlbumRequest;
import com.music.albums.model.AlbumResponse;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumMapper {
    public static AlbumResponse map(AlbumResponseDto albumResponseDto)
    {
        return new AlbumResponse(
                albumResponseDto.getId(),
                albumResponseDto.getCdName(),
                albumResponseDto.getReleaseDate());
    }

    public static List<AlbumResponse> map(List<AlbumResponseDto> albumResponseDtoList)
    {
        return albumResponseDtoList
                .stream()
                .map(AlbumMapper::map)
                .collect(Collectors.toList());
    }

    public static AlbumRequestDto map(AlbumRequest albumRequest)
    {
        return new AlbumRequestDto(
                albumRequest.getCdName(),
                albumRequest.getReleaseDate());
    }
}
