package com.example.creatorstore.services;

import com.example.creatorstore.dto.RegisterRequest;
import com.example.creatorstore.dto.RegisterResponse;
import com.example.creatorstore.entities.User;
import com.example.creatorstore.exceptions.UserAlreadyExistsException;
import com.example.creatorstore.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.creatorstore.dto.LoginRequest;
import com.example.creatorstore.dto.LoginResponse;
import com.example.creatorstore.exceptions.InvalidCredentialsException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public RegisterResponse register(RegisterRequest request) {

        if (userRepository.findByUsername(
                request.getUsername()
        ).isPresent()) {

            throw new UserAlreadyExistsException(
                    "Username already exists"
            );
        }

        if (userRepository.findByEmail(
                request.getEmail()
        ).isPresent()) {

            throw new UserAlreadyExistsException(
                    "Email already exists"
            );
        }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(
                        passwordEncoder.encode(
                                request.getPassword()
                        )
                )
                .role("CUSTOMER")
                .build();

        User savedUser = userRepository.save(user);

        return RegisterResponse.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .role(savedUser.getRole())
                .build();
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByUsername(
                request.getUsername()
        ).orElseThrow(
                InvalidCredentialsException::new
        );

        boolean matches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!matches) {
            throw new InvalidCredentialsException();
        }

        String token = jwtService.generateToken(
                user.getUsername()
        );
        return LoginResponse.builder()
                .token(token)
                .build();
    }
}