package com.non.employee.assignment.controllers;

import com.non.employee.assignment.dto.DepartmentDto;
import com.non.employee.assignment.dto.PositionDto;
import com.non.employee.assignment.services.PositionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PositionController {

    private final PositionService positionService ;
    public static final String POSITION_PATH = "/api/v1/position";

    public static final String POSITION_PATH_ID = "/api/v1/position/{departmentId}";

    @PostMapping(POSITION_PATH_ID)
    public ResponseEntity<PositionDto> createPosition(@PathVariable(value = "departmentId") Long departmentId,
                                                     @Valid @RequestBody PositionDto positionDto){
        return new ResponseEntity<>(positionService.createPosition(departmentId, positionDto), HttpStatus.CREATED);
    }

    @GetMapping(POSITION_PATH)
    public ResponseEntity<List<PositionDto>> getAllPositions() {
        return new ResponseEntity<>(positionService.getAllPositions(),HttpStatus.OK) ;
    }

}
