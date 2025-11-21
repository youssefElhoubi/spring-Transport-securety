package com.transportsecure.controller;

import com.transportsecure.dto.CreateUserDTO;
import com.transportsecure.dto.LogInDto;
import com.transportsecure.entity.User;
import com.transportsecure.service.JwtService;
import com.transportsecure.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    private UserService userService;
    private JwtService jwtService;
    private PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, JwtService jwtService , PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup")
    @PreAuthorize("@validationService.isValidSpecialty(#dto)")
    public ResponseEntity<?> signUp(@Valid @RequestBody CreateUserDTO dto) {
        User user = userService.createUser(dto);
        String Token = jwtService.createToken(user.getId(), Map.of("role", user.getRole().toString()));
        return ResponseEntity.ok(Token);
    }

    @PostMapping("login")
    public ResponseEntity<?> logIn(@Valid @RequestBody LogInDto dto){
        User user = userService.findByEmail(dto.getEmail());
        passwordEncoder.matches(dto.getPassword(), user.getPassword());
        String Token = jwtService.createToken(user.getId(), Map.of("role", user.getRole().toString()));
        return ResponseEntity.ok(Token);
    }
}
