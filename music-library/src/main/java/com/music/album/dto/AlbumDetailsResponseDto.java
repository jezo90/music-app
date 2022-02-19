package com.music.album.dto;

import java.util.Date;

public record AlbumDetailsResponseDto(
        Long id,
        String cdName,
        Date releaseDate,
        String author,
        String image) {
}
