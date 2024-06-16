package com.example.projektni_zadatak_programski_jezici.controller;

import com.example.projektni_zadatak_programski_jezici.entity.Department;
import com.example.projektni_zadatak_programski_jezici.model.DepartmentModel;
import com.example.projektni_zadatak_programski_jezici.service.DepartmentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "/api/department")
public class DepartmentController {

    private final DepartmentService service;

    @GetMapping
    public List<Department> getAll() {
        return service.getAllDepartment();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Department> getById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getDepartmentById(id));
    }

    @PostMapping
    public Department create(@RequestBody DepartmentModel model) {
        return service.saveDepartment(model);
    }

    @PutMapping(path = "/{id}")
    public Department update(@PathVariable Integer id,@RequestBody DepartmentModel model) {
        return service.updateDepartment(id,model);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.deleteDepartment(id);
    }
}
