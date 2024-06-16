package com.example.projektni_zadatak_programski_jezici.service;

import com.example.projektni_zadatak_programski_jezici.entity.Department;
import com.example.projektni_zadatak_programski_jezici.model.DepartmentModel;
import com.example.projektni_zadatak_programski_jezici.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository repository;

    public List<Department> getAllDepartment() {
        return repository.findAllByDeletedAtIsNull();
    }

    public Optional<Department> getDepartmentById(Integer id) {
        return repository.findByIdAndDeletedAtIsNull(id);
    }

    public Department saveDepartment(DepartmentModel model) {
        Department department = new Department();
        department.setName(model.getName());
        department.setCreatedAt(LocalDateTime.now());
        return repository.save(department);
    }

    public Department updateDepartment(Integer id, DepartmentModel model) {
        Department department = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        department.setName(model.getName());
        department.setUpdatedAt(LocalDateTime.now());
        return repository.save(department);
    }

    public void deleteDepartment(Integer id) {
        Department department = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        department.setDeletedAt(LocalDateTime.now());
        repository.save(department);
    }


}
