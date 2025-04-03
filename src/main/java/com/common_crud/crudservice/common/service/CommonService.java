package com.common_crud.crudservice.common.service;

import com.common_crud.crudservice.common.repository.CommonRepository;
import com.common_crud.crudservice.common.dto.MainDto;
import com.common_crud.crudservice.common.dto.list_response.CommonListResponseDto;
import com.common_crud.crudservice.common.dto.list_response.CommonPageResponseDto;
import com.common_crud.crudservice.common.entity.MainEntity;
import com.common_crud.crudservice.common.exception.ResourceNotFoundException;
import com.common_crud.crudservice.common.mappers.CommonMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CommonService<E extends MainEntity, RQ, RS extends MainDto> {
    default RS save(RQ requestDto) {
        E entity = getMapper().dtoToEntity(requestDto);

        E newEntity = validateAndSetForeignKeys(entity, requestDto);
        E savingEntity = getSavingEntity(entity, newEntity);

        return getMapper().entityToDto(getRepository().save(savingEntity));
    }

    default E getSavingEntity(E entity, E newEntity) {
        if (newEntity == null) return entity;
        else return newEntity;
    }

    default RS update(long assetId, RQ requestDto) {
        E existingEntity = this.getEntity(assetId);

        E newEntity = validateAndSetForeignKeys(existingEntity, requestDto);

        E savingEntity = getSavingEntity(existingEntity, newEntity);
        getMapper().updateExistingEntity(requestDto, savingEntity);
        return getMapper().entityToDto(getRepository().save(newEntity));
    }

    default RS getById(long assetId) {
        E asset = getEntity(assetId);
        return getMapper().entityToDto(asset);
    }

    default CommonListResponseDto<MainDto> getAll() {
        List<E> entityList = getRepository().findAllByIsActiveIsTrue();
        return CommonListResponseDto.builder()
                .dataList(getMapper().entityListToDtoList(entityList))
                .build();
    }

    default CommonPageResponseDto<MainDto> getAllPageable(Pageable pageable) {
        Page<E> assetPages = getRepository().findAllByIsActiveIsTrue(pageable);

        CommonPageResponseDto<MainDto> pageResponse = new CommonPageResponseDto<>();
        pageResponse.setDataList(getMapper().entityListToDtoList(assetPages.getContent()));
        pageResponse.setTotalPages(assetPages.getTotalPages());
        pageResponse.setTotalElements(assetPages.getTotalElements());

        return pageResponse;
    }

    default MainDto delete(long assetId) {
        E existingEntity = getEntity(assetId);
        existingEntity.setIsActive(false);

        return getMapper().entityToDto(getRepository().save(existingEntity));
    }

    CommonMapper<E, RQ, RS> getMapper();

    CommonRepository<E> getRepository();

    E validateAndSetForeignKeys(E entity, RQ requestDto);

    default E getEntity(long assetId) {
        Optional<E> asset = getRepository().findByIdAndIsActiveIsTrue(assetId);

        if(asset.isEmpty()) {
            throw new ResourceNotFoundException(
                    "Resource Not Found from given Id",
                    Map.of("id", String.valueOf(assetId))
            );
        }

        return asset.get();
    }
}
