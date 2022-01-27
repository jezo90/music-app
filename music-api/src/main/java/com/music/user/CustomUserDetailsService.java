package com.music.user;

import com.music.user.mapper.UserMapper;
import com.music.user.model.UserResponse;
import com.music.user.port.outbound.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String username){

        return userRepository
                        .findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException(""));
    }
}
