package com.non.employee.assignment.services;

import com.non.employee.assignment.dto.EmployeeDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto requestDto) ;

    List<EmployeeDto> getAllEmployees(String employeeName) ;

    EmployeeDto uploadImage(String employeeCode , MultipartFile file) ;

    Optional<EmployeeDto> getEmployeeByEmployeeCode(String employeeCode) ;

    byte[] downloadImage(String fileName) ;

    Optional<EmployeeDto> updateEmployeeByEmployeeCode(String employeeCode, EmployeeDto requestDto);

}
