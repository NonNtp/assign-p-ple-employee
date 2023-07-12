package com.non.employee.assignment.repositories;

import com.non.employee.assignment.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByImageName(String filename) ;

    Optional<Employee> findByEmployeeCode(String employeeCode) ;

    boolean existsByFirstNameAndLastName(String firstName, String lastName);

    List<Employee> findAllByEmployeeNameIsLikeIgnoreCase(String employeeName) ;

}
