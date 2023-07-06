package com.non.employee.assignment.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyDto {

    private Long companyId ;

    @NotEmpty(message = "company can not empty")
    private String companyName ;
}
