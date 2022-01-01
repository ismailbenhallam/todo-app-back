package org.todoapp.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.todoapp.dto.TodoDto;
import org.todoapp.dto.TodoToSaveDto;
import org.todoapp.exceptions.NotFoundException;
import org.todoapp.mappers.TodoMapper;
import org.todoapp.models.Todo;
import org.todoapp.repositories.TodoRepository;
import org.todoapp.services.TodoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    @Override
    public TodoDto saveTodoDto(TodoToSaveDto dto) {
        return todoMapper.todoDtoFromTodo(todoRepository.save(todoMapper.todoFromTodoToSaveDto(dto)));
    }

    @Override
    public TodoDto updateTodoDto(TodoDto dto) {
        Todo existingTodo = todoRepository.findById(dto.getId()).orElseThrow(() -> new NotFoundException("Todo with id %d not found".formatted(dto.getId())));
        Todo todo = todoMapper.todoFromTodoToSaveDto(dto);
        todo.setId(existingTodo.getId());

        return todoMapper.todoDtoFromTodo(todoRepository.save(todo));
    }

    @Override
    public TodoDto getTodoDtoById(long id) {
        return todoMapper.todoDtoFromTodo(todoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Todo with id %d not found".formatted(id))));
    }

    @Override
    public List<TodoDto> getAllTodoDto() {
        return todoMapper.todoDtoListFromTodoList(todoRepository.findAll());
    }
}
