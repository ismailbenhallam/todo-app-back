package org.todoapp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.todoapp.dto.TodoDto;
import org.todoapp.models.Todo;
import org.todoapp.models.TodoPriority;
import org.todoapp.models.TodoState;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

    TodoDto todoDtoFromTodo(Todo todo);

    Todo todoFromTodoDto(TodoDto dto);

    default int stateOrdinal(TodoState state) {
        return state.ordinal();
    }

    default int priorityOrdinal(TodoPriority priority){
        return priority.ordinal();
    }

    default TodoPriority priorityFromOrdinal(int ordinal){
        return TodoPriority.values()[ordinal];
    }

    default TodoState stateFromOrdinal(int ordinal){
        return TodoState.values()[ordinal];
    }

    default List<TodoDto> todoDtosFromTodos(List<Todo> todos){
        return todos.stream().map(INSTANCE::todoDtoFromTodo).toList();
    }

}
