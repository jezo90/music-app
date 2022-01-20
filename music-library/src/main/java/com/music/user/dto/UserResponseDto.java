package com.music.user.dto;

import lombok.Value;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Value
public class UserResponseDto {
    String username;
    String password;
    Collection<? extends GrantedAuthority> authorities;
}
