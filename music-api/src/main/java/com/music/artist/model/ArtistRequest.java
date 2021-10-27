package com.music.artist.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
@AllArgsConstructor
public class ArtistRequest {
    private String nickname;
    private String firstName;
    private String lastName;
    private Date birthDate;
}
