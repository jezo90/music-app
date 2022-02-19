package com.music.album.model;

import java.util.Date;

public record AlbumDetailsResponse(
        Long id,
        String cdName,
        Date releaseDate,
        String author,
        String image) {
}
