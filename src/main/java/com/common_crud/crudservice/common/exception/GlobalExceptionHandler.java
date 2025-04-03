package com.common_crud.crudservice.common.exception;

import com.common_crud.crudservice.common.exception.dto.ExceptionResponseDto;
import com.common_crud.crudservice.common.util.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleUnhandledException(Exception exception) {
        log.error("ERROR: {}", exception.getMessage());
        ExceptionResponseDto response = ExceptionResponseDto.builder()
                .message("Something went wrong!")
                .build();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleStudentNotFoundException(ResourceNotFoundException exception) {
        log.error("ERROR: {}", exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getExceptionResponseDto());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException exception) {
        log.error("ERROR: {}", exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Helper.getValidationErrorResponse(exception));
    }
}
