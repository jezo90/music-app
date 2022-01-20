package com.music.role.dto;

import com.music.role.dao.RoleName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
public class RoleResponseDto {
    private final Long id;
    private final RoleName roleName;
}
