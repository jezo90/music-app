package com.music.album.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class AlbumDetailsResponse {
    private final String cdName;
    private final Date releaseDate;
    private final String author;
}
