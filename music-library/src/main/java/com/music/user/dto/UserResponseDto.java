package com.music.user.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public record UserResponseDto(
        String username,
        String password,
        Collection<? extends GrantedAuthority> authorities) {
}
