package com.example.projektni_zadatak_programski_jezici.service;


import com.example.projektni_zadatak_programski_jezici.entity.Employee;
import com.example.projektni_zadatak_programski_jezici.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }
    public Optional<Employee> getEmployeeById(Integer id){
        return repository.findById(id);
    }

    public Optional<Employee> getEmployeeByContact(String contact){
        return repository.findByContact(contact);
    }
}
