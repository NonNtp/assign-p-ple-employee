package com.non.employee.assignment.services;

import com.non.employee.assignment.dto.CompanyDto;
import com.non.employee.assignment.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    CompanyDto createCompany(CompanyDto requestDto) ;

    List<CompanyDto> getAllCompanies() ;

    Optional<CompanyDto> updateCompanyByCompanyId(Long companyId, CompanyDto companyDto);


}
