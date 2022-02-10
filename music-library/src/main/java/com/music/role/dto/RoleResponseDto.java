package com.music.role.dto;

import com.music.role.dao.RoleName;

public record RoleResponseDto(
        Long id,
        RoleName roleName) {
}
