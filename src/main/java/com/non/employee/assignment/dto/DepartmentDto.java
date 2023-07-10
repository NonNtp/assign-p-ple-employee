package com.non.employee.assignment.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class DepartmentDto {

    private Long departmentId ;

    @NotEmpty(message = "department can not empty")
    private String departmentName ;

    private String departmentDescription ;

    private Set<PositionDto> positions ;
}
