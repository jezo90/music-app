package com.music.user;

import com.music.user.dao.UserEntity;
import com.music.user.port.outbound.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
class UserService {

    private final UserRepository userRepository;

    public UserEntity saveUser(UserEntity userEntity)
    {
        return userRepository.saveUser(userEntity);
    }
}
