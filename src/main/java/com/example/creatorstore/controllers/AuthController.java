package com.example.creatorstore.controllers;

import com.example.creatorstore.dto.RegisterRequest;
import com.example.creatorstore.dto.RegisterResponse;
import com.example.creatorstore.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.creatorstore.dto.LoginRequest;
import com.example.creatorstore.dto.LoginResponse;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public RegisterResponse register(
            @Valid @RequestBody RegisterRequest request
    ) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(
            @Valid @RequestBody LoginRequest request
    ) {
        return userService.login(request);
    }
}