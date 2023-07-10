package com.non.employee.assignment.dto;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class EmployeeDto {

    private Long employeeId ;

    private String employeeCode ;

    private String firstName ;

    private String lastName ;

    private String employeeName;

    @Email
    private String email ;

    private String userLogin ;

    private String company ;

    private BigDecimal salary;

    private String contactNumber;

    private String position;

    private String department;

    private LocalDate hiredDate;

    private LocalDate resignedDate;

    private String status ;

    private byte[] image ;

    private String imageType ;

    private String imageName ;
}
