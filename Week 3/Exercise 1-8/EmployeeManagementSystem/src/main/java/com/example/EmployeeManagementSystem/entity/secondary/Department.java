package com.example.EmployeeManagementSystem.entity.secondary;

import com.example.EmployeeManagementSystem.config.Auditable;
import com.example.EmployeeManagementSystem.entity.primary.Employee;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "departments")
@NamedQueries({
        @NamedQuery(
                name = "Department.findByNameNamedQuery",
                query = "SELECT d FROM Department d WHERE d.name = :name"
        ),
        @NamedQuery(
                name = "Department.findWithEmployeesMoreThan",
                query = "SELECT d FROM Department d WHERE size(d.employees) > :employeeCount"
        )
})
@EntityListeners(AuditingEntityListener.class) // Registering the auditing listener
public class Department extends Auditable { // Extend Auditable

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;

}
