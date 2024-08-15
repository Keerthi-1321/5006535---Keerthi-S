package com.example.EmployeeManagementSystem.entity.primary;

import com.example.EmployeeManagementSystem.config.Auditable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//import com.fasterxml.jackson.annotation.JsonBackReference;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "employees")
@EntityListeners(AuditingEntityListener.class) // Registering the auditing listener

public class Employee extends Auditable { // Extend Auditable

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private com.example.EmployeeManagementSystem.entity.secondary.Department department;
    //@JsonBackReference

}




