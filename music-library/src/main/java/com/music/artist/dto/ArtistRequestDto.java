package com.music.artist.dto;

import java.util.Date;

public record ArtistRequestDto(
        String nickname,
        String firstName,
        String lastName,
        Date birthDate) {
}