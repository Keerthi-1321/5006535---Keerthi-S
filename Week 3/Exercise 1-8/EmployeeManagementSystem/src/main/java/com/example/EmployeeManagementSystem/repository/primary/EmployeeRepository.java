package com.example.EmployeeManagementSystem.repository.primary;

import com.example.EmployeeManagementSystem.entity.primary.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.EmployeeManagementSystem.projection.EmployeeNameProjection;
import com.example.EmployeeManagementSystem.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query method to find employees by name
    List<Employee> findByName(String name);

    // Derived query method to find employees by department id
    //List<Employee> findByDepartmentId(Long departmentId);

    // Derived query method to find employees by email
    List<Employee> findByEmail(String email);

    // Custom query to find employees by a part of their name
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:namePart%")
    List<Employee> findByNameContaining(@Param("namePart") String namePart);

    Page<Employee> findByNameContaining(String namePart, Pageable pageable);

    // Interface-based projection
    List<EmployeeNameProjection> findByDepartmentId(Long departmentId);

    // Class-based projection using @Query
    @Query("SELECT new com.example.EmployeeManagementSystem.dto.EmployeeDTO(e.name, e.email) FROM Employee e WHERE e.department.id = :departmentId")
    List<EmployeeDTO> findEmployeeDTOByDepartmentId(@Param("departmentId") Long departmentId);

}
