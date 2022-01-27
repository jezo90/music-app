package com.music.user.api;

import com.music.exception.EntityNotFoundException;
import com.music.role.port.inbound.RoleComponent;
import com.music.user.JwtUtil;
import com.music.user.dao.UserEntity;
import com.music.user.mapper.UserMapper;
import com.music.user.model.UserRequest;
import com.music.user.model.UserResponse;
import com.music.user.model.UserToken;
import com.music.user.port.inbound.UserComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
class UserController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final RoleComponent roleComponent;
    private final UserComponent userComponent;

    @GetMapping("/")
    public String welcome() {
        return "czesc";
    }

    @PostMapping("/login")
    public ResponseEntity<UserToken> generateToken(@RequestBody UserRequest userRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userRequest.login(), userRequest.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return ResponseEntity.ok(
                new UserToken(
                jwtUtil.generateJwtToken(authentication)));
    }

    @PostMapping("/register")
    public UserEntity register(@RequestBody UserRequest userRequest) {
        UserEntity user = new UserEntity();
        user.setUsername(userRequest.login());
        user.setPassword(passwordEncoder.encode(userRequest.password()));
        user.setEmail(userRequest.email());

        user.setRoles(Collections.singletonList(
                UserMapper.map(roleComponent.findById(1L))));
        user.setEnabled(true);

        if( userComponent.usernameExists(user.getUsername()) )
        {
            throw new EntityNotFoundException("Username is already taken!");
        }

        if( userComponent.emailExists(user.getEmail()) )
        {
            throw new EntityNotFoundException("Email is already taken!");
        }

        return userComponent.saveUser(user);
    }

    @GetMapping("/get")
    public String get() {

        return "XD";
    }
}
