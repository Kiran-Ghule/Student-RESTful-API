package com.student.api.ApiAdvise;

import com.student.api.Exceptions.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<ApiError> notFoundExcep(NotFound exception)
    {

        ApiError api=ApiError.builder().status(HttpStatus.NOT_FOUND).message("Record in not Found").suberr(null).build();
        return new ResponseEntity<>(api,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> notValid(MethodArgumentNotValidException exception)
    {
        List<String> list = exception.getBindingResult()
                                    .getAllErrors()
                                    .stream()
                                    .map(err->err.getDefaultMessage())
                                    .collect(Collectors.toList());

        return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST,"Data is Invalid...",list),HttpStatus.BAD_REQUEST);
    }

}
