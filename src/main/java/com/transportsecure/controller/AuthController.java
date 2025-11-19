package com.transportsecure.controller;

import com.transportsecure.dto.CreateUserDTO;
import com.transportsecure.entity.User;
import com.transportsecure.service.JwtService;
import com.transportsecure.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    public AuthController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping
    @PreAuthorize("@validationService.isValidSpecialty(#dto)")
    public ResponseEntity<?> signUp(@Valid @RequestBody CreateUserDTO dto) {
        User user = userService.createUser(dto);
        String Token = jwtService.createToken(user.getId(), Map.of("role", user.getRole()));
        return ResponseEntity.ok(Token);
    }
}
