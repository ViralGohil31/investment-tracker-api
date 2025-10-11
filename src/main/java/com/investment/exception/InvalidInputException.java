package com.investment.exception;

import lombok.Getter;
import java.util.List;

import static com.investment.model.response.ApiResponse.ApiError;

@Getter
public class InvalidInputException extends RuntimeException {
    private final List<ApiError> errors;

    public InvalidInputException(List<ApiError> errors, String message) {
        super(message);
        this.errors = errors;
    }
}
