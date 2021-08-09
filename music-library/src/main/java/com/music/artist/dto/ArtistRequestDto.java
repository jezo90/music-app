package com.music.artist.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ArtistRequestDto {
    private final String name;
}