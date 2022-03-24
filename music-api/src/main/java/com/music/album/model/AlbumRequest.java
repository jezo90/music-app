package com.music.album.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public record AlbumRequest(
        String cdName,
        Date releaseDate,
        Long artistId,
        MultipartFile image) {
}
