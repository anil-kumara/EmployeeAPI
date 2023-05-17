package com.springcode.EmployeeAPI.service;

import com.springcode.EmployeeAPI.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> findAll();
    EmployeeEntity findById(int theId);
    EmployeeEntity save(EmployeeEntity theEmployee);
    void deleteById(int theId);
}
