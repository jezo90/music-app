package com.music.album.model;

import java.util.Date;

public record AlbumResponse(
        Long id,
        String cdName,
        Date releaseDate,
        String authorId) {
}
