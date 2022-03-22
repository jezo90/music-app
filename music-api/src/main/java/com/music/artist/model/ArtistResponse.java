package com.music.artist.model;

import java.util.Date;

public record ArtistResponse(
        Long id,
        String nickname,
        String firstName,
        String lastName,
        Date birthDate,
        byte[] image
) {
}