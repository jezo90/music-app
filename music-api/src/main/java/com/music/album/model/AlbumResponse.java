package com.music.album.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class AlbumResponse {
    private final Long id;
    private final String cdName;
    private final Date releaseDate;
    private final String authorId;
}
