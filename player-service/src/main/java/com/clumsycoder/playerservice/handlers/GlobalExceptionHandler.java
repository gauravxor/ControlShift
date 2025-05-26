package com.clumsycoder.playerservice.handlers;

import com.clumsycoder.controlshift.commons.exceptions.DuplicateResourceException;
import com.clumsycoder.controlshift.commons.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiResponse<Object>> handleDuplicateResource(DuplicateResourceException e) {
        ApiResponse<Object> errorResponse = new ApiResponse<>()
                .message(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}