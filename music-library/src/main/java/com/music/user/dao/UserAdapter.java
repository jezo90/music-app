package com.music.user.dao;

import com.music.user.port.outbound.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class UserAdapter implements UserRepository {

    private final UserSpringRepository userSpringRepository;

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return userSpringRepository
                .findByUsername(username);
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userSpringRepository.save(userEntity);
    }
}
