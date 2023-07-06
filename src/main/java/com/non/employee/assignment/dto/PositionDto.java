package com.non.employee.assignment.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PositionDto {

    @NotEmpty(message = "position can not empty")
    private String positionName ;

    private String positionDescription ;

    private String employmentType ;

    private String positionLevel ;

    private BigDecimal startingSalary ;

    private BigDecimal maxSalary ;

}
