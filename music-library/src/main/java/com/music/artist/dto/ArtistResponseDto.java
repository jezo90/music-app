package com.music.artist.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ArtistResponseDto {
    private final Long Id;
    private final String name;
}
