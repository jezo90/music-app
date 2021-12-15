package com.music.track.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
@AllArgsConstructor
public class TrackRequest {
    private String title;
    private String text;
    private Boolean feat;
    private Long album_id;
}
