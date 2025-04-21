package com.project.bookmanagementsystem.DTO;


public class ApiResponse {
    private Object response;
    private boolean success;

    public ApiResponse(Object response, boolean success) {
        this.response = response;
        this.success = success;
    }

    public Object getResponse() {
        return response;
    }

    public boolean isSuccess() {
        return success;
    }
}
