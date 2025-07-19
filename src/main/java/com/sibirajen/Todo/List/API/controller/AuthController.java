package com.sibirajen.Todo.List.API.controller;

import com.sibirajen.Todo.List.API.dto.LoginRequest;
import com.sibirajen.Todo.List.API.service.AuthService;
import com.sibirajen.Todo.List.API.dto.RegisterRequest;
import com.sibirajen.Todo.List.API.dto.Token;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Token> register(
            @Valid @RequestBody RegisterRequest registerRequest
            ){
        Token token = authService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(token);
    }

    @PostMapping("/login")
    public ResponseEntity<Token> login(
            @Valid @RequestBody LoginRequest loginRequest
            ){
        Token token = authService.login(loginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
