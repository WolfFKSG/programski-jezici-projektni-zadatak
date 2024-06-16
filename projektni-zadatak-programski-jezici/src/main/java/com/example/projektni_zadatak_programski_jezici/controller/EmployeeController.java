package com.example.projektni_zadatak_programski_jezici.controller;

import com.example.projektni_zadatak_programski_jezici.entity.Employee;
import com.example.projektni_zadatak_programski_jezici.model.EmployeeModel;
import com.example.projektni_zadatak_programski_jezici.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/employee")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {


    private final EmployeeService service;

    @GetMapping
    public List<Employee> getAllEmployees() {

        return service.getAllEmployees();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getEmployeeById(id));
    }

    @GetMapping(path = "/contact/{contact}")
    public List<Employee> getEmployeeByContactInfo(@PathVariable String contact) {
        return service.getEmployeeByContact(contact);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody EmployeeModel model) {
        return service.createEmployee(model);
    }

    @PutMapping(path = "/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody EmployeeModel model) {
        return service.updateEmployee(id, model);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Integer id) {
        service.deleteEmployee(id);
    }
}
