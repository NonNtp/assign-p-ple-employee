package com.non.employee.assignment.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class DepartmentDto {

    @NotEmpty(message = "department can not empty")
    private String departmentName ;

    private String departmentDescription ;
}
