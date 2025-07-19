package com.sibirajen.Todo.List.API.mapper;

import com.sibirajen.Todo.List.API.dto.RegisterRequest;
import com.sibirajen.Todo.List.API.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {
    public static User toEntity(RegisterRequest request, PasswordEncoder passwordEncoder){
        return User.builder()
                .name(request.getName())
                .email(request.getEmail().toLowerCase())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
    }
}
