package com.example.creatorstore.dto;

import com.example.creatorstore.entities.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponse {
    private Long id;
    private String username;
    private String email;
    private Role role;
}
