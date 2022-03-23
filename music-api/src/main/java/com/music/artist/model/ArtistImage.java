package com.music.artist.model;

public record ArtistImage(
        String imageName,
        String imageType,
        byte[] image
) {
}
