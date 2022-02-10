package com.music.album.dto;

import java.util.Date;

public record AlbumDetailsResponseDto(
        String cdName,
        Date releaseDate,
        String author) {
}
