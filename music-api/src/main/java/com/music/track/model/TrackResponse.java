package com.music.track.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class TrackResponse {
    private final String title;
    private final String text;
    private final Boolean feat;

}