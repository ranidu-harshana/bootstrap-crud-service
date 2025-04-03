package com.common_crud.crudservice.common.exception;

import java.util.Map;

public class ResourceNotFoundException extends MainException {
    public ResourceNotFoundException(String message, Map<String, Object> data) {
        super(message, data);
    }
}
