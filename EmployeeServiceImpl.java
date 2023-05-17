package com.springcode.EmployeeAPI.service;

import com.springcode.EmployeeAPI.dao.EmployeeDAO;
import com.springcode.EmployeeAPI.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    //constructor injection
    private EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO=theEmployeeDAO;
    }
    @Override
    public List<EmployeeEntity> findAll(){
        return employeeDAO.findAll();
    }

    @Override
    public EmployeeEntity findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Transactional
    @Override
    public EmployeeEntity save(EmployeeEntity theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
    employeeDAO.deleteById(theId);
    }
}
