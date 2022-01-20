package com.music.user.dao;

import com.music.user.dto.UserResponseDto;
import com.music.user.port.outbound.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class UserAdapter implements UserRepository {

    private final UserSpringRepository userSpringRepository;

    @Override
    public Optional<UserResponseDto> findByUsername(String username) {
        return userSpringRepository
                .findByUsername(username)
                .map(UserEntityMapper::map);
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userSpringRepository.save(userEntity);
    }
}
