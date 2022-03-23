package com.music.artist.dto;

public record ArtistImageDto(
        String imageName,
        String imageType,
        byte[] image
) {
}
