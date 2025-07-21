package com.sibirajen.Todo.List.API.service;

import com.sibirajen.Todo.List.API.dto.TaskRequest;
import com.sibirajen.Todo.List.API.dto.TaskResponse;
import com.sibirajen.Todo.List.API.exception.TaskNotFoundException;
import com.sibirajen.Todo.List.API.mapper.TaskMapper;
import com.sibirajen.Todo.List.API.model.Task;
import com.sibirajen.Todo.List.API.repo.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepo taskRepo;

    public TaskResponse createTask(TaskRequest taskRequest) {
        Task task = TaskMapper.toEntity(taskRequest);
        Task savedTask = this.taskRepo.save(task);
        return TaskMapper.toDTO(savedTask);
    }

    public TaskResponse updateTask(Long id, TaskRequest taskRequest) {
        Task task = this.taskRepo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with id " + id + " not fount"));
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        Task updatedTask = this.taskRepo.save(task);
        return TaskMapper.toDTO(updatedTask);
    }

    public void deleteTask(Long id) {
        if(!this.taskRepo.existsById(id)){
            throw new TaskNotFoundException("Task with id " + id + " not fount");
        }
        this.taskRepo.deleteById(id);
    }
}
