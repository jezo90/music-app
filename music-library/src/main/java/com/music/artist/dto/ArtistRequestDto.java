package com.music.artist.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public record ArtistRequestDto(
        String nickname,
        String firstName,
        String lastName,
        Date birthDate,
        MultipartFile image) {
}