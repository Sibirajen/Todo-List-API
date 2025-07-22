package com.sibirajen.Todo.List.API.controller;

import com.sibirajen.Todo.List.API.dto.TaskRequest;
import com.sibirajen.Todo.List.API.dto.TaskResponse;
import com.sibirajen.Todo.List.API.dto.TaskListResponse;
import com.sibirajen.Todo.List.API.service.TaskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/todos")
    public ResponseEntity<TaskResponse> createTask(
            @Valid @RequestBody TaskRequest taskRequest
    ){
        TaskResponse taskResponse = this.taskService.createTask(taskRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskResponse);
    }

    @PostMapping("/todos/{id}")
    public ResponseEntity<TaskResponse> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody TaskRequest taskRequest
    ){
        TaskResponse taskResponse = this.taskService.updateTask(id, taskRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskResponse);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> deleteTask(
            @PathVariable Long id
    ){
        this.taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/todos")
    public ResponseEntity<TaskListResponse> getTask(
            @RequestParam(required = false, defaultValue = "1") @Min(1) int page,
            @RequestParam(required = false, defaultValue = "10") @Min(1) int limit
    ){
        TaskListResponse taskListResponse = this.taskService.getTasks(page, limit);
        return ResponseEntity.ok(taskListResponse);
    }
}
