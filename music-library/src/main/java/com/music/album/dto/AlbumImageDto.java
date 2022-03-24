package com.music.album.dto;

public record AlbumImageDto(
        String imageName,
        String imageType,
        byte[] image
) {
}

