package org.todoapp.services;

import org.todoapp.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto saveTodoDto(TodoDto dto);

    TodoDto updateTodoDto(TodoDto dto);

    TodoDto getTodoDtoById(long id);

    List<TodoDto> getAllTodoDto();
}
