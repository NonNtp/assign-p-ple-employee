package com.non.employee.assignment.services;

import com.non.employee.assignment.dto.PositionDto;
import com.non.employee.assignment.entities.Department;
import com.non.employee.assignment.entities.Position;
import com.non.employee.assignment.mappers.PositionMapper;
import com.non.employee.assignment.repositories.DepartmentRepository;
import com.non.employee.assignment.repositories.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository ;

    private final DepartmentRepository departmentRepository ;

    private final PositionMapper positionMapper ;
    @Override
    public PositionDto createPosition(Long departmentId, PositionDto requestDto) {

        Position positionNew = positionMapper.position(requestDto) ;

        Department department = departmentRepository.findById(departmentId).orElseThrow();

        positionNew.setDepartment(department);

        Position positionSave = positionRepository.save(positionNew) ;

        return positionMapper.positionDto(positionSave) ;
    }

    @Override
    public List<PositionDto> getAllPositions() {
        return positionRepository.findAll().stream().map(positionMapper ::positionDto).collect(Collectors.toList());

    }

    @Override
    public Optional<PositionDto> getPositionByDepartmentId(Long departmentId) {
        return Optional.empty();
    }


}
