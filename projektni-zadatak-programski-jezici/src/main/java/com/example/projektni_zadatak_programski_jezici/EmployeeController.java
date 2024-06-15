package com.example.projektni_zadatak_programski_jezici;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/employee")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {

    private final EmployeeRepository repository;

    @GetMapping
    public List<Employee> getAllEmployees() {
    return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        return ResponseEntity.of(repository.findById(id));
    }

}
