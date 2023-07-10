package com.non.employee.assignment.repositories;

import com.non.employee.assignment.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PositionRepository extends JpaRepository<Position,Long> {

}
