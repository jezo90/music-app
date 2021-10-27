package com.music.artist.mapper;

import com.music.artist.dto.ArtistRequestDto;
import com.music.artist.dto.ArtistResponseDto;
import com.music.artist.model.ArtistRequest;
import com.music.artist.model.ArtistResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ArtistMapper {

    public static ArtistResponse map(ArtistResponseDto artistResponseDto)
    {
        return new ArtistResponse(
                artistResponseDto.getId(),
                artistResponseDto.getNickname(),
                artistResponseDto.getFirstName(),
                artistResponseDto.getLastName(),
                artistResponseDto.getBirthDate());
    }

    public static List<ArtistResponse> map(List<ArtistResponseDto> artistResponseDtoList)
    {
        return artistResponseDtoList
                .stream()
                .map(ArtistMapper::map)
                .collect(Collectors.toList());
    }

    public static ArtistRequestDto map(ArtistResponse artistResponse)
    {
        return new ArtistRequestDto(
                artistResponse.getNickname(),
                artistResponse.getFirstName(),
                artistResponse.getLastName(),
                artistResponse.getBirthDate());
    }

    public static List<ArtistRequestDto> mapToDto(List<ArtistRequest> artistRequestList)
    {
        return artistRequestList
                .stream()
                .map(ArtistMapper::map)
                .collect(Collectors.toList());
    }

    public static ArtistRequestDto map(ArtistRequest artistRequest)
    {
        return new ArtistRequestDto(
                artistRequest.getNickname(),
                artistRequest.getFirstName(),
                artistRequest.getLastName(),
                artistRequest.getBirthDate());
    }
}
