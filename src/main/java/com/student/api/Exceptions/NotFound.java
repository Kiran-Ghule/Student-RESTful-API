package com.student.api.Exceptions;

public class NotFound extends RuntimeException{
    public NotFound(String message)
    {
        super(message);
    }
}
