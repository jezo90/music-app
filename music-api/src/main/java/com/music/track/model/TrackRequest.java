package com.music.track.model;

public record TrackRequest(
        String title,
        String text,
        Boolean feat,
        Long album_id) { }
