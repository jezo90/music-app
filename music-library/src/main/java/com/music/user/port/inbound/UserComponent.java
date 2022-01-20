package com.music.user.port.inbound;

import com.music.user.dao.UserEntity;

public interface UserComponent {
    UserEntity saveUser(UserEntity userEntity);
}
