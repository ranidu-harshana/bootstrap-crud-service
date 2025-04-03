package com.common_crud.crudservice.common.exception.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ExceptionResponseDto {
    private String message;
    private Map<String, Object> data;
}
