package com.common_crud.crudservice.common.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MainDto {
    private long id;
    private Date createdAt;
    private Date updatedAt;
}
