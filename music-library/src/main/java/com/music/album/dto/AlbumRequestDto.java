package com.music.album.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public record AlbumRequestDto(
        String cdName,
        Date releaseDate,
        Long artistId,
        MultipartFile image) {
}

