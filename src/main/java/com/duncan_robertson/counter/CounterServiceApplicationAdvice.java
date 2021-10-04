package com.duncan_robertson.counter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CounterServiceApplicationAdvice {
    private static final String ARGUMENT_NOT_VALID_MESSAGE = "Invalid property value provided";
    Logger logger = LoggerFactory.getLogger(CounterServiceApplicationAdvice.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleArgumentNotValidException(
        MethodArgumentNotValidException e
    ) {
        String message;
        FieldError err = e.getFieldError();
        if (err != null) {
            message = err.getField() + ": " + err.getDefaultMessage();
        } else {
            message = ARGUMENT_NOT_VALID_MESSAGE;
        }

        return buildResponse(HttpStatus.BAD_REQUEST, message);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(
        Exception e
    ) {
        return buildResponse(e.getMessage());
    }

    private ResponseEntity<ErrorResponse> buildResponse(HttpStatus status, String message) {
        return new ResponseEntity<>(
            new ErrorResponse(
                String.valueOf(status.value()),
                message
            ),
            status
        );
    }

    private ResponseEntity<ErrorResponse> buildResponse(String message) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
