package com.non.employee.assignment.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id" , nullable = false)
    private Long departmentId ;

    @Column(name = "department_name" , nullable = false , unique = true)
    private String departmentName ;

    @Column(name = "department_desc")
    private String departmentDescription ;

    @OneToMany(mappedBy = "department")
    @Builder.Default
    private Set<Position> positions = new HashSet<>() ;

}
