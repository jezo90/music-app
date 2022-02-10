package com.music.user.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public record UserResponse(
        String username,
        String password,
        Collection<? extends GrantedAuthority> authorities) {
}
