package com.common_crud.crudservice.demo_project.mappers;

import com.common_crud.crudservice.common.mappers.CommonMapper;
import com.common_crud.crudservice.demo_project.dto.request.DemoRequestDto;
import com.common_crud.crudservice.demo_project.dto.response.DemoResponseDto;
import com.common_crud.crudservice.demo_project.entity.DemoEntity;
import org.mapstruct.factory.Mappers;

public interface DemoMapper  extends CommonMapper<DemoEntity, DemoRequestDto, DemoResponseDto> {
    DemoMapper INSTANCE = Mappers.getMapper( DemoMapper.class );
}
