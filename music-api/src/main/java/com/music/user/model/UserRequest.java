package com.music.user.model;

public record UserRequest(
        String login,
        String password
) { }
