package com.clumsycoder.controlshift.commons.response;

import java.util.Map;

public class ApiResponse {
    private String message;
    private Object errors;
    private Map<String, Object> data;


    public ApiResponse message(String message) {
        this.message = message;
        return this;
    }


    public ApiResponse errors(Object errors) {
        this.errors = errors;
        return this;
    }

    public ApiResponse data(Map<String, Object> data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getErrors() {
        return this.errors;
    }

    public Map<String, Object> getData() {
        return this.data;
    }
}