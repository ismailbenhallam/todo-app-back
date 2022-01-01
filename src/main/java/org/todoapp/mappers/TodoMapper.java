package org.todoapp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.todoapp.dto.TodoToSaveDto;
import org.todoapp.dto.TodoDto;
import org.todoapp.models.Todo;
import org.todoapp.models.TodoPriority;
import org.todoapp.models.TodoState;

import java.util.List;

@Mapper(componentModel = "spring", imports = {TodoPriority.class, TodoState.class})
public interface TodoMapper {

    @Mapping(target = "priority", expression = "java(TodoPriority.values()[dto.getPriority()])")
    @Mapping(target = "state", expression = "java(TodoState.values()[dto.getState()])")
    Todo todoFromTodoToSaveDto(TodoToSaveDto dto);


    @Mapping(target = "priority", expression = "java(todo.getPriority().ordinal())")
    @Mapping(target = "state", expression = "java(todo.getState().ordinal())")
    TodoDto todoDtoFromTodo(Todo todo);

    @Mapping(target = "priority", expression = "java(TodoPriority.values()[dto.getPriority()])")
    @Mapping(target = "state", expression = "java(TodoState.values()[dto.getState()])")
    Todo todoFromTodoToSaveDto(TodoDto dto);

    List<TodoDto> todoDtoListFromTodoList(List<Todo> todos);

}
