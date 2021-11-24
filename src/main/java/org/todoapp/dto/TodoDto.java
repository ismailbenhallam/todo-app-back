package org.todoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: 22/11/2021 Use @Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {
    private long id;
    private String title;
    private String description;
    private int priority;
    private int state;
    private String completionDate;

}
