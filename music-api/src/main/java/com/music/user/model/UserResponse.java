package com.music.user.model;

import lombok.Value;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Value
public class UserResponse {
    String username;
    String password;
    Collection<? extends GrantedAuthority> authorities;
}
