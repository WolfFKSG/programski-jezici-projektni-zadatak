package com.example.projektni_zadatak_programski_jezici.repository;

import com.example.projektni_zadatak_programski_jezici.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByDeletedAtIsNull();

    Optional<Employee> findByIdAndDeletedAtIsNull(Integer id);

    List<Employee> findByContactContainsAndDeletedAtIsNull(String contact);

}
