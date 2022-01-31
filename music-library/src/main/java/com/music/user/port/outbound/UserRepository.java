package com.music.user.port.outbound;

import com.music.user.dao.UserEntity;

import java.util.Optional;

public interface UserRepository {
    Optional<UserEntity> findByUsername(String username);
    UserEntity saveUser(UserEntity userEntity);
    Boolean usernameExists(String username);
    Boolean emailExists(String email);
}
