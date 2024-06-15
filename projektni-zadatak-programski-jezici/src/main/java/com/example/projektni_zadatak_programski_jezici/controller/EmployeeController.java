package com.example.projektni_zadatak_programski_jezici.controller;

import com.example.projektni_zadatak_programski_jezici.entity.Employee;
import com.example.projektni_zadatak_programski_jezici.service.EmployeeService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<Employee> getEmployeeByContactInfo(@PathVariable String contact) {
        return ResponseEntity.of(service.getEmployeeByContact(contact));
    }

}
