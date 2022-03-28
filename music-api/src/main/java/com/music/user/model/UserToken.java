package com.music.user.model;

import com.music.role.dao.RoleEntity;

import java.util.List;

public record UserToken(
        String token,
        Long userId,
        String username,
        String email,
        List<String> roles) {
}
