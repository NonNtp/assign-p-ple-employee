package com.non.employee.assignment.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "employee_code" , unique = true)
    private String employeeCode;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "user_login", unique = true)
    private String userLogin;

    @Column(name = "company")
    private String company;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "contact_number", unique = true)
    private String contactNumber;

    @Column(name = "position")
    private String position;

    @Column(name = "department")
    private String department;

    @Column(name = "hired_date")
    private LocalDate hiredDate;

    @Column(name = "resigned_date")
    private LocalDate resignedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "image" , length = 1000)
    @Lob
    private byte[] image ;

    private String imageType ;

    private String imageName ;

    public Employee(Long employeeId, String employeeCode, String firstName, String lastName, String employeeName, String email,
                    String userLogin, String company, BigDecimal salary, String contactNumber, String position, String department,
                    LocalDate hiredDate, LocalDate resignedDate, String status, byte[] image, String imageType, String imageName) {
        this.employeeId = employeeId;
        this.employeeCode = String.format("%05d", Integer.parseInt(employeeCode));



        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
        this.employeeName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase() + " " + lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase() ;

        String[] companyEmailArr = company.split(" ") ;
        String companyEmail = companyEmailArr[0].toLowerCase() ;
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase().charAt(0) + "@" + companyEmail + ".co.th";

        this.userLogin = firstName.toLowerCase() + "." + lastName.toLowerCase().charAt(0) ;

        this.company = company;
        this.salary = salary;
        this.contactNumber = contactNumber;
        this.position = position;
        this.department = department;
        this.hiredDate = hiredDate;
        this.resignedDate = resignedDate;

        if (this.status == null) {
            this.status = "Active" ;
        } else {
            this.status = status ;
        }

        this.image = image;
        this.imageType = imageType;
        this.imageName = imageName;
    }
}
