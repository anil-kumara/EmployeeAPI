package com.springcode.EmployeeAPI.rest;

import com.springcode.EmployeeAPI.dao.EmployeeDAO;
import com.springcode.EmployeeAPI.entity.EmployeeEntity;
import com.springcode.EmployeeAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    //private EmployeeDAO employeeDAO;
    private EmployeeService employeeService;

    //quick constructor inject employee DAO/ EmployeeService
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    //return list of employees
    @GetMapping("/employees")
    public List<EmployeeEntity> findAll() {
        return employeeService.findAll();
    }

    //add mapping for GET / employees / {employeeId}
    @GetMapping("/employees/{employeeId}")
    public EmployeeEntity getEmployee(@PathVariable int employeeId){
        EmployeeEntity theEmployee=employeeService.findById(employeeId);
        if(theEmployee==null){
            throw new RuntimeException("Employee Id not found "+employeeId);
        }
        return theEmployee;
    }

    //add mapping for POST / employees -add new employee
    @PostMapping("/employees")
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity theEmployee){
        //also just in case if they pass id in json... set id =0
        //this is to force a save new item... instead of update
    theEmployee.setId(0);
    EmployeeEntity dbEmployee=employeeService.save(theEmployee);
    return dbEmployee;
    }

    //add mapping for PUT / employee - update existing employee
    @PutMapping("/employees")
    public EmployeeEntity upDateEmployee(@RequestBody EmployeeEntity theEmployee){
        EmployeeEntity dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    //add mapping for delete/employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        EmployeeEntity tempEmployee = employeeService.findById(employeeId);
        //throw exception if Null

        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found - " +employeeId);
        }
        employeeService.deleteById(employeeId);
        return "employee data deleted successfully @Id of "+employeeId;
    }



}
