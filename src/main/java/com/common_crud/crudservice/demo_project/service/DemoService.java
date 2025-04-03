package com.common_crud.crudservice.demo_project.service;

import com.common_crud.crudservice.common.service.CommonService;
import com.common_crud.crudservice.demo_project.dto.request.DemoRequestDto;
import com.common_crud.crudservice.demo_project.dto.response.DemoResponseDto;
import com.common_crud.crudservice.demo_project.entity.DemoEntity;

public interface DemoService  extends CommonService<DemoEntity, DemoRequestDto, DemoResponseDto> {
}
