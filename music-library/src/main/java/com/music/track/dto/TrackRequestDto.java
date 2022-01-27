package com.music.track.dto;

public record TrackRequestDto(
        String title,
        String text,
        Boolean feat,
        Long album_id) {
}