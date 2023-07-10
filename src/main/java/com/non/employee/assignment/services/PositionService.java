package com.non.employee.assignment.services;

import com.non.employee.assignment.dto.PositionDto;

import java.util.List;
import java.util.Optional;

public interface PositionService {

    PositionDto createPosition(Long departmentId, PositionDto requestDto);

    List<PositionDto> getAllPositions();

    Optional<PositionDto> getPositionByDepartmentId(Long departmentId) ;
}
