package com.music.user.port.outbound;

import com.music.user.dao.UserEntity;
import com.music.user.dto.UserResponseDto;

import java.util.Optional;

public interface UserRepository {
    Optional<UserResponseDto> findByUsername(String username);
    UserEntity saveUser(UserEntity userEntity);
}
