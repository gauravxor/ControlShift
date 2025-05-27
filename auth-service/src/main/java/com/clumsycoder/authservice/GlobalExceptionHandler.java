package com.clumsycoder.authservice;

import com.clumsycoder.controlshift.commons.exceptions.DuplicateResourceException;
import com.clumsycoder.controlshift.commons.exceptions.ResourceNotFoundException;
import com.clumsycoder.controlshift.commons.exceptions.UnauthorizedException;
import com.clumsycoder.controlshift.commons.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiResponse> handleDuplicateResource(DuplicateResourceException e) {
        return new ResponseEntity<>(new ApiResponse().errors(e.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFound(ResourceNotFoundException e) {
        return new ResponseEntity<>(new ApiResponse().errors(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ApiResponse> handleUnauthorizedAccess(UnauthorizedException e) {
        return new ResponseEntity<>(new ApiResponse().errors(e.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}