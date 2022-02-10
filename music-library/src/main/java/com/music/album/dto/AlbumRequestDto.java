package com.music.album.dto;

import java.util.Date;

public record AlbumRequestDto(
        String cdName,
        Date releaseDate,
        Long artistId) {
}

