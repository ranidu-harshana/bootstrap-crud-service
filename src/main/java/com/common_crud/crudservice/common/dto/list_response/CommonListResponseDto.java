package com.common_crud.crudservice.common.dto.list_response;

import com.common_crud.crudservice.common.dto.MainDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CommonListResponseDto<RS extends MainDto> {
    private List<RS> dataList;
}
