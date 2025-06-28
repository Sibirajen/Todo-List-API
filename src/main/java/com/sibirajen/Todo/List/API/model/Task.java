package com.sibirajen.Todo.List.API.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "TASKS")
@Access(AccessType.FIELD)
public class Task extends BaseEntity{
    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DESCRIPTION", length = 1000)
    private String description;
}
