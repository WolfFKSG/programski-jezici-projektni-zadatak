package com.example.projektni_zadatak_programski_jezici.repository;


import com.example.projektni_zadatak_programski_jezici.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    List<Department> findAllByDeletedAtIsNull();

    Optional<Department> findByIdAndDeletedAtIsNull(Integer id);
}
