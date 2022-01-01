package org.todoapp.services;

import org.todoapp.dto.TodoToSaveDto;
import org.todoapp.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto saveTodoDto(TodoToSaveDto dto);

    TodoDto updateTodoDto(TodoDto dto);

    TodoDto getTodoDtoById(long id);

    List<TodoDto> getAllTodoDto();
}
