package com.common_crud.crudservice.common.util;

import com.common_crud.crudservice.common.exception.dto.ExceptionResponseDto;
import lombok.experimental.UtilityClass;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UtilityClass
public class Helper {
    public ExceptionResponseDto getValidationErrorResponse(MethodArgumentNotValidException exception) {
        List<FieldError> errors = exception.getBindingResult().getFieldErrors();

        Map<String, Object> data = new HashMap<>();

        errors.forEach(error -> data.put(error.getField(), error.getRejectedValue()));

        return ExceptionResponseDto.builder()
                .message("Request payload contain invalid data")
                .data(data)
                .build();
    }
}
