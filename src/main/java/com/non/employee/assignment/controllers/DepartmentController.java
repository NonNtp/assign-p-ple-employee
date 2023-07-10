package com.non.employee.assignment.controllers;

import com.non.employee.assignment.dto.DepartmentDto;
import com.non.employee.assignment.services.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService ;
    public static final String DEPARTMENT_PATH = "/api/v1/department";
    public static final String DEPARTMENT_PATH_ID = "/api/v1/department/{departmentId}";
    public static final String DEPARTMENT_PATH_NAME = "/api/v1/department/name/{departmentName}";


    @PostMapping(DEPARTMENT_PATH)
    public ResponseEntity<DepartmentDto> createDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.createDepartment(departmentDto) , HttpStatus.CREATED) ;
    }

    @GetMapping(DEPARTMENT_PATH)
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return new ResponseEntity<>(departmentService.getAllDepartments(),HttpStatus.OK) ;
    }

    @GetMapping(DEPARTMENT_PATH_ID)
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable(value = "departmentId") Long departmentId) {
        return new ResponseEntity<>(departmentService.getDepartmentById(departmentId).orElseThrow() , HttpStatus.OK) ;
    }

    @GetMapping(DEPARTMENT_PATH_NAME)
    public ResponseEntity<DepartmentDto> getDepartmentByName(@PathVariable(value = "departmentName") String departmentName) {
        return new ResponseEntity<>(departmentService.getDepartmentByName(departmentName).orElseThrow() , HttpStatus.OK) ;
    }

}
