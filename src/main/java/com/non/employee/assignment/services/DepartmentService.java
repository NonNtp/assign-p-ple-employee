package com.non.employee.assignment.services;

import com.non.employee.assignment.dto.DepartmentDto;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto requestDto) ;

    List<DepartmentDto> getAllDepartments () ;

    Optional<DepartmentDto> getDepartmentByName (String departmentName) ;

    Optional<DepartmentDto> getDepartmentById (Long departmentId) ;
}
