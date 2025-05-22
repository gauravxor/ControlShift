package com.clumsycoder.controlshift.commons.response;

public class ApiResponse<T> {
    private String message;
    private String errors;
    private T data;


    public ApiResponse<T> message(String message) {
        this.message = message;
        return this;
    }


    public ApiResponse<T> errors(String errors) {
        this.errors = errors;
        return this;
    }

    public ApiResponse<T> data(T data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public String getErrors() {
        return errors;
    }

    public T getData() {
        return data;
    }
}