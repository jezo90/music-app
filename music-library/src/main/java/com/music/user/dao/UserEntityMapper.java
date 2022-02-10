package com.music.user.dao;

import com.music.user.dto.UserResponseDto;

public class UserEntityMapper {

    public static UserResponseDto map(UserEntity userEntity) {
        return new UserResponseDto(
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getAuthorities()
        );
    }
}
