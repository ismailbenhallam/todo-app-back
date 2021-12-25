package org.todoapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.todoapp.dto.TodoDto;
import org.todoapp.services.TodoService;

import java.util.Collection;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<Collection<TodoDto>> getAll() {
        return ResponseEntity.ok(todoService.getAllTodoDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(todoService.getTodoDtoById(id));
    }

    @PostMapping
    public ResponseEntity<TodoDto> saveTodo(@ModelAttribute TodoDto todoDto) {
        return ResponseEntity.ok(todoService.saveTodoDto(todoDto));
    }

}
