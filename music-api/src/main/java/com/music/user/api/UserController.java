package com.music.user.api;

import com.music.role.port.inbound.RoleComponent;
import com.music.user.JwtUtil;
import com.music.user.dao.UserEntity;
import com.music.user.mapper.UserMapper;
import com.music.user.model.UserRequest;
import com.music.user.model.UserResponse;
import com.music.user.model.UserToken;
import com.music.user.port.inbound.UserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@CrossOrigin("*")
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

    @PostMapping("/login")
    public ResponseEntity<UserToken> generateToken(@RequestBody UserRequest userRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userRequest.getLogin(), userRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return ResponseEntity.ok(
                new UserToken(
                jwtUtil.generateJwtToken(authentication)));
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
