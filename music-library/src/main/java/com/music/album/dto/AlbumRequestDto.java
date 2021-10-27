package com.music.album.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class AlbumRequestDto {
    private final String cdName;
    private final Date releaseDate;
    private final Long artistId;
}

