package com.music.album.mapper;

import com.music.album.dto.AlbumDetailsResponseDto;
import com.music.album.dto.AlbumRequestDto;
import com.music.album.dto.AlbumResponseDto;
import com.music.album.model.AlbumDetailsResponse;
import com.music.album.model.AlbumRequest;
import com.music.album.model.AlbumResponse;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumMapper {
    public static AlbumResponse map(AlbumResponseDto albumResponseDto)
    {
        return new AlbumResponse(
                albumResponseDto.getId(),
                albumResponseDto.getCdName(),
                albumResponseDto.getReleaseDate(),
                albumResponseDto.getAuthorId());
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
                albumRequest.getReleaseDate(),
                albumRequest.getArtistId());
    }

    public static AlbumDetailsResponse map(AlbumDetailsResponseDto albumDetailsResponseDto)
    {
        return new AlbumDetailsResponse(
                albumDetailsResponseDto.getCdName(),
                albumDetailsResponseDto.getReleaseDate(),
                albumDetailsResponseDto.getAuthor());
    }
}
