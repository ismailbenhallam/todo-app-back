package org.todoapp.controllers.advice;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.todoapp.controllers.TodoController;
import org.todoapp.exceptions.NotFoundException;

@Log4j2
@RestControllerAdvice(basePackageClasses = TodoController.class)
public class ExceptionsHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> noSuchElementException(NotFoundException ex) {
        log.info(ex.getMessage());
        return new ResponseEntity<>(new ApiError(ex.getMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }
}