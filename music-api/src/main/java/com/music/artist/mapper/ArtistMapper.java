package com.music.artist.mapper;

import com.music.artist.dto.ArtistRequestDto;
import com.music.artist.dto.ArtistResponseDto;
import com.music.artist.model.ArtistRequest;
import com.music.artist.model.ArtistResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ArtistMapper {

    public static ArtistResponse map(ArtistResponseDto artistResponseDto) {
        return new ArtistResponse(
                artistResponseDto.id(),
                artistResponseDto.nickname(),
                artistResponseDto.firstName(),
                artistResponseDto.lastName(),
                artistResponseDto.birthDate(),
                artistResponseDto.image()
        );
    }

    public static List<ArtistResponse> map(List<ArtistResponseDto> artistResponseDtoList) {
        return artistResponseDtoList
                .stream()
                .map(ArtistMapper::map)
                .collect(Collectors.toList());
    }


    public static ArtistRequestDto map(ArtistRequest artistRequest) throws IOException {
        return new ArtistRequestDto(
                artistRequest.nickname(),
                artistRequest.firstName(),
                artistRequest.lastName(),
                artistRequest.birthDate(),
                artistRequest.image()
        );
    }
}
