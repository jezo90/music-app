package com.music.artist.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class ArtistRequestDto {
    private final String nickname;
    private final String firstName;
    private final String lastName;
    private final Date birthDate;
}