package com.non.employee.assignment.controllers;

import com.non.employee.assignment.dto.CompanyDto;
import com.non.employee.assignment.dto.EmployeeDto;
import com.non.employee.assignment.exceptions.NotFoundException;
import com.non.employee.assignment.services.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CompanyController {

    private final CompanyService companyService ;
    public static final String COMPANY_PATH = "/api/v1/company";

    public static final String COMPANY_PATH_ID = "/api/v1/company/{companyId}";

    @PostMapping(COMPANY_PATH)
    public ResponseEntity<CompanyDto> createCompany(@Valid @RequestBody CompanyDto companyDto) {
        return new ResponseEntity<>(companyService.createCompany(companyDto) , HttpStatus.CREATED) ;
    }

    @GetMapping(COMPANY_PATH)
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
        return new ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK) ;
    }

    @PutMapping(COMPANY_PATH_ID)
    public ResponseEntity updateEmployeeByEmployeeCode(@PathVariable("companyId") Long companyId,
                                                       @Valid @RequestBody CompanyDto companyDto) {
        if (companyService.updateCompanyByCompanyId(companyId, companyDto).isEmpty()) {
            throw new NotFoundException();
        }

        return new ResponseEntity("Update Success",HttpStatus.OK);
    }
}

