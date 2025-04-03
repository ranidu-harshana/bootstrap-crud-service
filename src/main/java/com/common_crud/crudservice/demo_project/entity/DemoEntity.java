package com.common_crud.crudservice.demo_project.entity;

import com.common_crud.crudservice.common.entity.MainEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "demo_tbl")
public class DemoEntity extends MainEntity {
}
