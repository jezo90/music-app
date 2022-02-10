package com.music.album.dto;

import java.util.Date;

public record AlbumResponseDto(
        Long id,
        String cdName,
        Date releaseDate,
        String authorId) {
}
