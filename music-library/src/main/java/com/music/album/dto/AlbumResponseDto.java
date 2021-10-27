package com.music.album.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class AlbumResponseDto {
    private final Long id;
    private final String cdName;
    private final Date releaseDate;
}
