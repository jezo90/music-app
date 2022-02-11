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
    public static AlbumResponse map(AlbumResponseDto albumResponseDto) {
        return new AlbumResponse(
                albumResponseDto.id(),
                albumResponseDto.cdName(),
                albumResponseDto.releaseDate(),
                albumResponseDto.authorId()
        );
    }

    public static List<AlbumResponse> map(List<AlbumResponseDto> albumResponseDtoList) {
        return albumResponseDtoList
                .stream()
                .map(AlbumMapper::map)
                .collect(Collectors.toList());
    }

    public static AlbumRequestDto map(AlbumRequest albumRequest) {
        return new AlbumRequestDto(
                albumRequest.cdName(),
                albumRequest.releaseDate(),
                albumRequest.artistId()
        );
    }

    public static AlbumDetailsResponse map(AlbumDetailsResponseDto albumDetailsResponseDto) {
        return new AlbumDetailsResponse(
                albumDetailsResponseDto.cdName(),
                albumDetailsResponseDto.releaseDate(),
                albumDetailsResponseDto.author(),
                albumDetailsResponseDto.image()
        );
    }

    public static List<AlbumDetailsResponse> mapToDetails(List<AlbumDetailsResponseDto> albumDetailsResponseDtoList) {
        return albumDetailsResponseDtoList
                .stream()
                .map(AlbumMapper::map)
                .collect(Collectors.toList());
    }
}
