package org.todoapp.services;

import org.todoapp.models.Todo;

import java.util.List;

public interface TodoService {
    Todo save(Todo todo);

    Todo update(Todo todo);

    Todo findById(long id);

    List<Todo> findAll();
}
