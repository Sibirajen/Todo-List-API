package com.sibirajen.Todo.List.API.service;

import com.sibirajen.Todo.List.API.dto.LoginRequest;
import com.sibirajen.Todo.List.API.dto.RegisterRequest;
import com.sibirajen.Todo.List.API.dto.Token;
import com.sibirajen.Todo.List.API.exception.UsernameAlreadyExistsException;
import com.sibirajen.Todo.List.API.mapper.UserMapper;
import com.sibirajen.Todo.List.API.model.User;
import com.sibirajen.Todo.List.API.repo.UserRepo;
import com.sibirajen.Todo.List.API.security.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public Token register(RegisterRequest registerRequest) {
        if(userRepo.existsByEmail(registerRequest.getEmail())){
            throw new UsernameAlreadyExistsException("User with email " + registerRequest.getEmail() + " already exists");
        }
        User user = UserMapper.toEntity(registerRequest, this.passwordEncoder);
        this.userRepo.save(user);
        String token = this.jwtService.generateToken(user);
        return Token.builder()
                .token(token)
                .build();
    }

    public Token login(LoginRequest loginRequest) {
        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );
        User user = this.userRepo.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + loginRequest.getEmail() + " not found"));
        String token = this.jwtService.generateToken(user);
        return Token.builder()
                .token(token)
                .build();
    }
}
