package org.todoapp.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
//@Log4j2
public class ExceptionsHandler {

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String noSuchElementException(NoSuchElementException ex) {
//        log.error("Error: " + ex.getMessage());
        return ex.getMessage();
    }
}