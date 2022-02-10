package com.music.album.model;

import java.util.Date;

public record AlbumDetailsResponse(
        String cdName,
        Date releaseDate,
        String author) {
}
