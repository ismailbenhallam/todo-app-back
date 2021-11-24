package org.todoapp.services.impl;

import org.springframework.stereotype.Service;
import org.todoapp.models.Todo;
import org.todoapp.repositories.TodoRepository;
import org.todoapp.services.TodoService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo update(Todo todo) {
        Todo existingTodo = todoRepository.findById(todo.getId()).orElseThrow(() -> new NoSuchElementException("Todo with id %d not found".formatted(todo.getId())));
        Todo updatedTodo = Todo.builder()
                .id(existingTodo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .priority(todo.getPriority())
                .state(todo.getState())
                .completionDate(existingTodo.getCompletionDate()).build();
        return todoRepository.save(updatedTodo);
    }

    @Override
    public Todo findById(long id) {
        return todoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Todo with id %d not found".formatted(id)));
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }
}
