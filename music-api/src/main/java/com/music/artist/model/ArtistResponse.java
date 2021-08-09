package com.music.artist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ArtistResponse {
    private final Long id;
    private final String name;
}