package com.non.employee.assignment.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id" , nullable = false)
    private Long positionId ;

    @Column(name = "position_name" , nullable = false)
    private String positionName ;

    @Column(name = "position_desc")
    private String positionDescription ;

    @Column(name = "employment_type")
    private String employmentType ;

    @Column(name = "position_level")
    private String positionLevel ;

    @Column(name = "starting_salary")
    private BigDecimal startingSalary ;

    @Column(name = "max_salary")
    private BigDecimal maxSalary ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_department_id" , nullable = false)
    private Department department ;

}
