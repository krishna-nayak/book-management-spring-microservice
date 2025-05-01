package com.project.bookmanagementsystem.advice;

import com.project.bookmanagementsystem.dto.ApiResponse;
import com.project.bookmanagementsystem.Exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BookNotFoundException.class)
    public ApiResponse handleUserException(BookNotFoundException ex){
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("errorMessage", ex.getMessage());

        ApiResponse apiResponse = new ApiResponse(errorMap, false);

        return apiResponse;
    }
}
