package com.common_crud.crudservice.common.exception;

import com.common_crud.crudservice.common.exception.dto.ExceptionResponseDto;

import java.util.Map;

public class MainException extends RuntimeException {
    private final String message;
    private final Map<String, Object> data;

    public MainException(String message, Map<String, Object> data) {
        super(message);
        this.message = message;
        this.data = data;
    }

    public ExceptionResponseDto getExceptionResponseDto() {
        return ExceptionResponseDto.builder()
                .message(this.message)
                .data(this.data)
                .build();
    }
}
