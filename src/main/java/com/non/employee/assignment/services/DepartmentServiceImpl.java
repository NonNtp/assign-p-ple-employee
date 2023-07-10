package com.non.employee.assignment.services;

import com.non.employee.assignment.dto.DepartmentDto;
import com.non.employee.assignment.mappers.DepartmentMapper;
import com.non.employee.assignment.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository ;

    private final DepartmentMapper departmentMapper ;

    @Override
    public DepartmentDto createDepartment(DepartmentDto requestDto) {
        return departmentMapper.departmentDto(departmentRepository.save(departmentMapper.department(requestDto))) ;
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        return departmentRepository.findAll().stream().map(departmentMapper :: departmentDto).collect(Collectors.toList());
    }

    @Override
    public Optional<DepartmentDto> getDepartmentByName(String departmentName) {
        return Optional.ofNullable(departmentMapper.departmentDto(departmentRepository.findByDepartmentName(departmentName).orElseThrow())) ;
    }

    @Override
    public Optional<DepartmentDto> getDepartmentById(Long departmentId) {
        return Optional.ofNullable(departmentMapper.departmentDto(departmentRepository.findById(departmentId).orElseThrow())) ;
    }
}
