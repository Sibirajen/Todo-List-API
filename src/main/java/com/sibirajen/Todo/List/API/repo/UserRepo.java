package com.sibirajen.Todo.List.API.repo;

import com.sibirajen.Todo.List.API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
