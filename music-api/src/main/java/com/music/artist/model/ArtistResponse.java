package com.music.artist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class ArtistResponse {
    private final Long id;
    private final String nickname;
    private final String firstName;
    private final String lastName;
    private final Date birthDate;
}