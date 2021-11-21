package com.music.track.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
@AllArgsConstructor
public class TrackRequest {
    private String nickname;
}
