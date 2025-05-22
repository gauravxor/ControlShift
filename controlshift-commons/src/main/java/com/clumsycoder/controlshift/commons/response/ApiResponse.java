package com.clumsycoder.controlshift.commons.response;

public class ApiResponse<T> {
    private String status;
    private String message;
    private Integer code;
    private String errors;
    private T data;

    public ApiResponse<T> status(String status) {
        this.status = status;
        return this;
    }

    public ApiResponse<T> message(String message) {
        this.message = message;
        return this;
    }

    public ApiResponse<T> code(Integer code) {
        this.code = code;
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

    // Getters
    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public String getErrors() {
        return errors;
    }

    public T getData() {
        return data;
    }
}