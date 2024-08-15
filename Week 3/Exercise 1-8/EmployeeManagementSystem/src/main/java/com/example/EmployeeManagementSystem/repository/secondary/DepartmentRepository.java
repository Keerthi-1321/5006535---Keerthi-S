package com.example.EmployeeManagementSystem.repository.secondary;

import com.example.EmployeeManagementSystem.dto.DepartmentDTO;
import com.example.EmployeeManagementSystem.entity.secondary.Department;
import com.example.EmployeeManagementSystem.projection.DepartmentNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Derived query method to find department by name
    Department findByName(String name);

    // Custom query to find departments with more than a specified number of employees
    @Query("SELECT d FROM Department d WHERE size(d.employees) > :employeeCount")
    List<Department> findDepartmentsWithMoreEmployeesThan(int employeeCount);

    // Interface-based projection
    List<DepartmentNameProjection> findAllProjectedBy();

    // Class-based projection using @Query
    @Query("SELECT new com.example.EmployeeManagementSystem.dto.DepartmentDTO(d.name) FROM Department d")
    List<DepartmentDTO> findDepartmentDTO();
}
