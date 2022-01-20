package com.music.user.api;

import com.music.role.port.inbound.RoleComponent;
import com.music.user.JwtUtil;
import com.music.user.dao.UserEntity;
import com.music.user.mapper.UserMapper;
import com.music.user.model.UserRequest;
import com.music.user.port.inbound.UserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;


@RestController
class UserController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleComponent roleComponent;

    @Autowired
    private UserComponent userComponent;

    @GetMapping("/")
    public String welcome() {
        return "czesc";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody UserRequest userRequest) throws Exception {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userRequest.getLogin(), userRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtUtil.generateJwtToken(authentication);
    }

    @PostMapping("/register")
    public UserEntity register(@RequestBody UserRequest userRequest) {
        UserEntity user = new UserEntity();
        user.setUsername(userRequest.getLogin());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        user.setRoles(Collections.singletonList(
                UserMapper.map(roleComponent.findById(1L))));
        user.setEnabled(true);

        return userComponent.saveUser(user);
    }

    @GetMapping("/get")
    public String get() {

        return "XD";
    }
}
