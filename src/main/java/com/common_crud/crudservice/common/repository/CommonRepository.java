package com.common_crud.crudservice.common.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface CommonRepository<T> extends JpaRepository<T, Long> {
    Optional<T> findByIdAndIsActiveIsTrue(long id);

    List<T> findAllByIsActiveIsTrue();

    Page<T> findAllByIsActiveIsTrue(Pageable pageable);
}
