package com.non.employee.assignment.services;

import com.non.employee.assignment.dto.CompanyDto;

import java.util.List;

public interface CompanyService {

    CompanyDto createCompany(CompanyDto requestDto) ;

    List<CompanyDto> getAllCompanies() ;


}
