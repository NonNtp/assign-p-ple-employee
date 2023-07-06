package com.non.employee.assignment.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id" , nullable = false )
    private Long companyId ;

    @Column(name = "company_name" , nullable = false , unique = true)
    private String companyName ;

}
