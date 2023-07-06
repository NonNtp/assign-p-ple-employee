package com.non.employee.assignment.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_code" , nullable = false )
    private Long employeeCode ;

    @Column(name = "email" , unique = true)
    private String email ;

    @Column(name = "first_name" , nullable = false)
    private String firstName ;

    @Column(name = "last_name" , nullable = false)
    private String lastName ;

    @Column(name = "user_login" , unique = true)
    private String userLogin ;

    @Column(name = "company" )
    private String company ;

    @Column(name = "salary" )
    private BigDecimal salary;

    @Column(name = "contact_number" , unique = true)
    private String contactNumber;

    @Column(name = "position")
    private String position;

    @Column(name = "department")
    private String department;

    @Column(name = "hired_date")
    private LocalDate hiredDate;

    @Column(name = "resigned_date")
    private LocalDate resignedDate;

    @Column(name = "status" )
    private String status ;


}
