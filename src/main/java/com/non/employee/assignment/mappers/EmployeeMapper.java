package com.non.employee.assignment.mappers;


import com.non.employee.assignment.dto.EmployeeDto;
import com.non.employee.assignment.entities.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {
    Employee employee (EmployeeDto dto) ;

    EmployeeDto employeeDto (Employee employee) ;
}
