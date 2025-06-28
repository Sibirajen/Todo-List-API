package com.sibirajen.Todo.List.API.mapper;

import com.sibirajen.Todo.List.API.dto.RegisterRequest;
import com.sibirajen.Todo.List.API.model.User;

public class UserMapper {
    public static User toEntity(RegisterRequest request){
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }
}
