package com.sibirajen.Todo.List.API.repo;

import com.sibirajen.Todo.List.API.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
}
