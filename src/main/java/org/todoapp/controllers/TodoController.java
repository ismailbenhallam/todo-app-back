package org.todoapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.todoapp.controllers.advice.ApiError;
import org.todoapp.dto.TodoDto;
import org.todoapp.dto.TodoToSaveDto;
import org.todoapp.services.TodoService;

import java.util.List;

@RestController
@RequestMapping("/todos")
@Tag(name = "Todos API")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @Operation(summary = "Get all todos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = List.class))})})
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAll() {
        return ResponseEntity.ok(todoService.getAllTodoDto());
    }


    @Operation(summary = "Get a todo by it's id", parameters = {
            @Parameter(name = "id", description = "Todo id", example = "1", required = true)
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = TodoDto.class))}),
            @ApiResponse(responseCode = "404", description = "Todo id not found",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ApiError.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(todoService.getTodoDtoById(id));
    }

    @Operation(summary = "Save a new todo", parameters = {
            @Parameter(name = "todo", description = "Todo", required = true)
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = TodoToSaveDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping
    public ResponseEntity<TodoDto> saveTodo(@ModelAttribute TodoToSaveDto todoToSaveDto) {
        return ResponseEntity.ok(todoService.saveTodoDto(todoToSaveDto));
    }

}
