package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.repository.primary.PrimaryEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private PrimaryEmployeeRepository primaryEmployeeRepository;

    @Transactional
    public List<Employee> findAll() {
        return primaryEmployeeRepository.findAll();
    }

    @Transactional
    public Optional<Employee> findById(Long id) {
        return primaryEmployeeRepository.findById(id);
    }

    @Transactional
    public Employee save(Employee employee) {
        return primaryEmployeeRepository.save(employee);
    }

    @Transactional
    public void deleteById(Long id) {
        primaryEmployeeRepository.deleteById(id);
    }

    @Transactional
    public void saveAll(List<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            primaryEmployeeRepository.save(employees.get(i));
            if (i % 20 == 0) { // Flush a batch of inserts and release memory
                primaryEmployeeRepository.flush();
            }
        }
    }
}

