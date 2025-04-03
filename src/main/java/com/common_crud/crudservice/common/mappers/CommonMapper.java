package com.common_crud.crudservice.common.mappers;

import com.common_crud.crudservice.common.dto.MainDto;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface CommonMapper<E, RQ, RS extends MainDto> {
    List<MainDto> entityListToDtoList(List<E> entityList);

    RS entityToDto(E entity);

    E dtoToEntity(RQ requestDto);

    void updateExistingEntity(RQ requestDto, @MappingTarget E existingEntity);
}
