package com.non.employee.assignment.mappers;

import com.non.employee.assignment.dto.PositionDto;
import com.non.employee.assignment.entities.Position;
import org.mapstruct.Mapper;

@Mapper
public interface PositionMapper {

    Position position (PositionDto dto) ;

    PositionDto positionDto (Position position) ;
}
