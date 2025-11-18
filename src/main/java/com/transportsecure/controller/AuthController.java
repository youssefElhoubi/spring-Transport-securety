package com.transportsecure.controller;

import com.transportsecure.dto.CreateUserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO user) {

        return null;
    }
}
