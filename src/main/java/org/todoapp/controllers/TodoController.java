package org.todoapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.todoapp.dto.TodoDto;
import org.todoapp.mappers.TodoMapper;
import org.todoapp.services.TodoService;

import java.util.Collection;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;
    private static final TodoMapper todoMapper = TodoMapper.INSTANCE;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<Collection<TodoDto>> getAll() {
        return ResponseEntity.ok(todoMapper.todoDtosFromTodos(todoService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(todoMapper.todoDtoFromTodo(todoService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<TodoDto> saveTodo(@ModelAttribute TodoDto todoDto) {
        return ResponseEntity.ok(todoMapper.todoDtoFromTodo(todoService.save(todoMapper.todoFromTodoDto(todoDto))));
    }

}
