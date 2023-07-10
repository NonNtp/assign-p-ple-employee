package com.non.employee.assignment.controllers;

import com.non.employee.assignment.dto.EmployeeDto;
import com.non.employee.assignment.exceptions.NotFoundException;
import com.non.employee.assignment.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService ;
    public static final String EMPLOYEE_PATH = "/api/v1/employee";
    public static final String EMPLOYEE_PATH_ID = "/api/v1/employee/{employeeCode}";
    public static final String EMPLOYEE_PATH_IMAGE_ID = "/api/v1/employee/image/upload/{employeeCode}";
    public static final String EMPLOYEE_PATH_IMAGE_NAME = "/api/v1/employee/image/download/{filename}";


    @PostMapping(EMPLOYEE_PATH)
    public ResponseEntity<EmployeeDto> createCompany(@Valid @RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto) , HttpStatus.CREATED) ;
    }

    @GetMapping(EMPLOYEE_PATH)
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(@RequestParam(required = false) String employeeName) {
        return new ResponseEntity<>(employeeService.getAllEmployees(employeeName),HttpStatus.OK) ;
    }

    @PostMapping(EMPLOYEE_PATH_IMAGE_ID)
    public ResponseEntity<EmployeeDto> uploadProfileImage(@PathVariable(value = "employeeCode") String employeeCode, @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(employeeService.uploadImage(employeeCode,file) , HttpStatus.OK) ;
    }

    @GetMapping(EMPLOYEE_PATH_IMAGE_NAME)
    public ResponseEntity<?> downloadImage(@PathVariable(value = "filename") String fileName){
        byte[] imageData=employeeService.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/jpeg"))
                .body(imageData);

    }

    @PutMapping(EMPLOYEE_PATH_ID)
    public ResponseEntity updateEmployeeByEmployeeCode(@PathVariable("employeeCode") String employeeCode,
                                                       @Validated @RequestBody EmployeeDto employeeDto) {
        if (employeeService.updateEmployeeByEmployeeCode(employeeCode, employeeDto).isEmpty()) {
            throw new NotFoundException();
        }

        return new ResponseEntity("Update Success",HttpStatus.OK);
    }

}
