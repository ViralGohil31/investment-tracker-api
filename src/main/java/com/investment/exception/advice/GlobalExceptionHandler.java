package com.investment.exception.advice;

import com.investment.constant.ErrorCode;
import com.investment.exception.InvalidInputException;
import com.investment.exception.UserNotFoundException;
import com.investment.model.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.List;

import static com.investment.model.response.ApiResponse.ApiError;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final String TRY_AGAIN_ERROR_MESSAGE = "error occurred , please try again";

    @ExceptionHandler({InvalidInputException.class})
    public ResponseEntity<ApiResponse<String>> handleInvalidInputException(InvalidInputException ex) {
        log.error("investment-tracker-api: InvalidInputException : {} ", ex.getLocalizedMessage(), ex);
        return handleException(ex.getErrors(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<ApiResponse<String>> handleUserNotFoundException(UserNotFoundException ex) {
        log.error("investment-tracker-api: UserNotFoundException : {} ", ex.getLocalizedMessage(), ex);
        var error = ApiError.of(ErrorCode.USER_NOT_FOUND, ex.getLocalizedMessage());
        return handleException(List.of(error), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiResponse<String>> handleAnyException(Exception ex) {
        log.error("investment-tracker-api: Exception : {} ", ex.getLocalizedMessage(), ex);
        var error = ApiError.of(ErrorCode.INTERNAL_ERROR, TRY_AGAIN_ERROR_MESSAGE);
        return handleException(List.of(error), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private static ResponseEntity<ApiResponse<String>> handleException(List<ApiResponse.ApiError> errors, HttpStatus httpStatus) {
        ApiResponse<String> error = ApiResponse.<String> builder()
                .timestamp(Instant.now())
                .status(httpStatus.value())
                .errors(errors)
                .build();
        return new ResponseEntity<>(error, httpStatus);
    }
}
