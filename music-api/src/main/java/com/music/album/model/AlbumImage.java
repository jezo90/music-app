package com.music.album.model;

public record AlbumImage(
        String imageName,
        String imageType,
        byte[] image
) {
}

