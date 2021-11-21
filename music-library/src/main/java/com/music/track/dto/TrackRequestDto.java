package com.music.track.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class TrackRequestDto {
    private final String nickname;
}