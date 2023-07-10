package com.non.employee.assignment.mappers;

import com.non.employee.assignment.dto.DepartmentDto;

import com.non.employee.assignment.entities.Department;
import org.mapstruct.Mapper;

@Mapper
public interface DepartmentMapper {

    Department department (DepartmentDto dto) ;

    DepartmentDto departmentDto (Department department) ;
}
