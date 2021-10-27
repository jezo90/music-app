package com.music.album.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class AlbumDetailsResponseDto {
    private final String cdName;
    private final Date releaseDate;
    private final String author;
}
