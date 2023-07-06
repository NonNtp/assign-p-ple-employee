package com.non.employee.assignment.repositories;

import com.non.employee.assignment.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
