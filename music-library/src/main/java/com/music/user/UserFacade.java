package com.music.user;

import com.music.user.dao.UserEntity;
import com.music.user.port.inbound.UserComponent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class UserFacade implements UserComponent {


    private final UserService userService;

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userService.saveUser(userEntity);
    }

    @Override
    public Boolean usernameExists(String username) {
        return userService.usernameExists(username);
    }

    @Override
    public Boolean emailExists(String email) {
        return userService.emailExists(email);
    }
}
