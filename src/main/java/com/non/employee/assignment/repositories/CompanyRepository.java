package com.non.employee.assignment.repositories;

import com.non.employee.assignment.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company , Long> {
}
