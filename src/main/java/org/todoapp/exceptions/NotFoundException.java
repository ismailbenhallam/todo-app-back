package org.todoapp.exceptions;

public class NotFoundException extends RuntimeException{
    private static final String RESOURCE_NOT_FOUND_DEFAULT_MESSAGE = "Item doesn't exist";

    public NotFoundException(){
        super(RESOURCE_NOT_FOUND_DEFAULT_MESSAGE);
    }

    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
