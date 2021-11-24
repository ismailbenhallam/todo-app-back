package org.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.todoapp.models.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
