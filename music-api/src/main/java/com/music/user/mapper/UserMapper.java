package com.music.user.mapper;

import com.music.role.dao.RoleEntity;
import com.music.role.dto.RoleResponseDto;
import com.music.user.dto.UserResponseDto;
import com.music.user.model.UserResponse;


public class UserMapper {

    public static UserResponse map(UserResponseDto userResponseDto) {
        return new UserResponse(userResponseDto.username(), userResponseDto.password(), userResponseDto.authorities());
    }

    public static RoleEntity map(RoleResponseDto roleResponseDto) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(roleResponseDto.id());
        roleEntity.setRoleName(roleResponseDto.roleName());

        return roleEntity;
    }
}
