package com.music.role.dao;

import com.music.role.dto.RoleResponseDto;

public class RoleMapper {

    public static RoleResponseDto map(RoleEntity roleEntity)
    {
        return new RoleResponseDto(roleEntity.getId(), roleEntity.getRoleName() );
    }
}
