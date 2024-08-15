package com.example.EmployeeManagement.repository.primary;

import com.example.EmployeeManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrimaryEmployeeRepository extends JpaRepository<Employee, Long> {

    // Find an employee by their name
    Optional<Employee> findByName(String name);

    // Find employees by department
    List<Employee> findByDepartment(String department);

    // Custom query to find employees by department with a given name
    @Query("SELECT e FROM Employee e WHERE e.department = :department AND e.name = :name")
    List<Employee> findEmployeesByDepartmentAndName(@Param("department") String department, @Param("name") String name);

    // Custom query to count employees by department
    @Query("SELECT COUNT(e) FROM Employee e WHERE e.department = :department")
    long countEmployeesByDepartment(@Param("department") String department);

    // Find all employees and sort by name
    List<Employee> findAllByOrderByNameAsc();
}
