package com.music.albums.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
@AllArgsConstructor
public class AlbumRequest {
    private String cdName;
    private Date releaseDate;
}
