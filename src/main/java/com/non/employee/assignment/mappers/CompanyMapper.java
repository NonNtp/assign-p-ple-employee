package com.non.employee.assignment.mappers;

import com.non.employee.assignment.dto.CompanyDto;
import com.non.employee.assignment.entities.Company;
import org.mapstruct.Mapper;

@Mapper
public interface CompanyMapper {
    Company company (CompanyDto dto) ;

    CompanyDto companyDto (Company company) ;
}
