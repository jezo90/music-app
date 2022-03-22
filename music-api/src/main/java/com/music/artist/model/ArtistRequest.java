package com.music.artist.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public record ArtistRequest(
        String nickname,
        String firstName,
        String lastName,
        Date birthDate,
        MultipartFile image
) {
}
