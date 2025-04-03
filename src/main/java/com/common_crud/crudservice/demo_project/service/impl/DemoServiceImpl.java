package com.common_crud.crudservice.demo_project.service.impl;

import com.common_crud.crudservice.common.repository.CommonRepository;
import com.common_crud.crudservice.demo_project.dto.request.DemoRequestDto;
import com.common_crud.crudservice.demo_project.dto.response.DemoResponseDto;
import com.common_crud.crudservice.demo_project.entity.DemoEntity;
import com.common_crud.crudservice.common.mappers.CommonMapper;
import com.common_crud.crudservice.demo_project.mappers.DemoMapper;
import com.common_crud.crudservice.demo_project.repository.DemoRepository;
import com.common_crud.crudservice.demo_project.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DemoServiceImpl implements DemoService {
    private final DemoRepository demoRepository;

    @Override
    public CommonMapper<DemoEntity, DemoRequestDto, DemoResponseDto> getMapper() {
        return DemoMapper.INSTANCE;
    }

    @Override
    public CommonRepository<DemoEntity> getRepository() {
        return demoRepository;
    }

    @Override
    public DemoEntity validateAndSetForeignKeys(DemoEntity entity, DemoRequestDto requestDto) {
        return null;
    }
}
