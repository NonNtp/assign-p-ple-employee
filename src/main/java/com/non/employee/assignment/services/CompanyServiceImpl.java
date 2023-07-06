package com.non.employee.assignment.services;

import com.non.employee.assignment.dto.CompanyDto;
import com.non.employee.assignment.mappers.CompanyMapper;
import com.non.employee.assignment.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final CompanyMapper companyMapper ;

    @Override
    public CompanyDto createCompany(CompanyDto requestDto) {
        return companyMapper.companyDto(companyRepository.save(companyMapper.company(requestDto))) ;
    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        return companyRepository.findAll().stream().map(companyMapper :: companyDto).collect(Collectors.toList());
    }


}
