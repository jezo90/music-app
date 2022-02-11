package com.music.artist.dto;

import java.util.Date;

public record ArtistResponseDto(
        Long id,
        String nickname,
        String firstName,
        String lastName,
        Date birthDate,
        String image) {
}
