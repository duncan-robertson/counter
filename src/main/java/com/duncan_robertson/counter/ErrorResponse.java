package com.duncan_robertson.counter;

public class ErrorResponse {
    private String message;
    private String status;

    ErrorResponse() {}

    ErrorResponse(
        String status,
        String message
    ) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
