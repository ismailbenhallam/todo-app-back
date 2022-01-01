package org.todoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoToSaveDto {
    private String title;
    private String description;
    private int priority;
    private int state;
}
