package com.common_crud.crudservice.demo_project.repository;

import com.common_crud.crudservice.common.repository.CommonRepository;
import com.common_crud.crudservice.demo_project.entity.DemoEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends CommonRepository<DemoEntity> {
}
