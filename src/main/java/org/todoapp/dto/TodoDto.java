package org.todoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDto {
    private long id;
    private String title;
    private String description;
    private int priority;
    private int state;
    private String completionDate;

}
