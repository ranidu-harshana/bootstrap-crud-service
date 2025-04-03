package com.common_crud.crudservice.common.dto.list_response;

import com.common_crud.crudservice.common.dto.MainDto;
import com.common_crud.crudservice.common.dto.PageableDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CommonPageResponseDto<RS extends MainDto> extends PageableDto {
    private List<RS> dataList;
}
