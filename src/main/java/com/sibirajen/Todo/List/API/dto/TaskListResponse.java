package com.sibirajen.Todo.List.API.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskListResponse {
    private List<TaskResponse> data;
    private int page;
    private int limit;
    private int total;
}
