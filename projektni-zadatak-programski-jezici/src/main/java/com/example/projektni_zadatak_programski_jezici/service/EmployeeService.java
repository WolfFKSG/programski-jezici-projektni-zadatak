package com.example.projektni_zadatak_programski_jezici.service;


import com.example.projektni_zadatak_programski_jezici.entity.Department;
import com.example.projektni_zadatak_programski_jezici.entity.Employee;
import com.example.projektni_zadatak_programski_jezici.model.EmployeeModel;
import com.example.projektni_zadatak_programski_jezici.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;
    private final DepartmentService departmentService;

    public List<Employee> getAllEmployees() {
        return repository.findAllByDeletedAtIsNull();
    }

    public Optional<Employee> getEmployeeById(Integer id) {
        return repository.findByIdAndDeletedAtIsNull(id);
    }

    public List<Employee> getEmployeeByContact(String contact) {
        return repository.findByContactContainsAndDeletedAtIsNull(contact);
    }

    public Employee createEmployee(EmployeeModel model) {
        Department department = departmentService
                .getDepartmentById(model.getDepartmentId())
                .orElseThrow();
        Employee employee = new Employee();
        employee.setName(model.getName());
        employee.setSurname(model.getSurname());
        employee.setContact(model.getContact());
        employee.setDepartment(department);
        employee.setCreatedAt(LocalDateTime.now());
        return repository.save(employee);
    }

    public Employee updateEmployee(Integer id, EmployeeModel model) {
        Employee employee = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        Department department = departmentService
                .getDepartmentById(model.getDepartmentId())
                .orElseThrow();
        employee.setName(model.getName());
        employee.setSurname(model.getSurname());
        employee.setContact(model.getContact());
        employee.setDepartment(department);
        employee.setUpdatedAt(LocalDateTime.now());
        return repository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        Employee employee = repository.findByIdAndDeletedAtIsNull(id).orElse(null);
        employee.setDeletedAt(LocalDateTime.now());
        repository.save(employee);
    }
}
