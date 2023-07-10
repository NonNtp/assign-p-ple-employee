package com.non.employee.assignment.repositories;

import com.non.employee.assignment.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Optional<Department> findByDepartmentName (String departmentName) ;
}
