package com.music.track.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TrackResponseDto {
    private final String title;
    private final String text;
    private final Boolean feat;



}
