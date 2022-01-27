package com.music.artist.model;
import java.util.Date;

public record ArtistRequest(
        String nickname,
        String firstName,
        String lastName,
        Date birthDate
) { }
