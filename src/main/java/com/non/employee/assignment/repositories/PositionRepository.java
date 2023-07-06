package com.non.employee.assignment.repositories;

import com.non.employee.assignment.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PositionRepository extends JpaRepository<Position,Long> {
}
