package com.sibirajen.Todo.List.API.mapper;

import com.sibirajen.Todo.List.API.dto.TaskRequest;
import com.sibirajen.Todo.List.API.dto.TaskResponse;
import com.sibirajen.Todo.List.API.model.Task;

public class TaskMapper {
    public static Task toEntity(TaskRequest taskRequest){
        return Task.builder()
                .title(taskRequest.getTitle())
                .description(taskRequest.getDescription())
                .build();
    }

    public static TaskResponse toDTO(Task task){
        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .build();
    }
}
