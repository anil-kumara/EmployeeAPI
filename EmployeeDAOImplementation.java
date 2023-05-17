package com.springcode.EmployeeAPI.dao;

import com.springcode.EmployeeAPI.entity.EmployeeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO{

    //define a field for entity
    private EntityManager entityManager;

    //set a constructor injection
    @Autowired
    public EmployeeDAOImplementation(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public List<EmployeeEntity> findAll() {
        //create a query
        TypedQuery<EmployeeEntity> theQuery= entityManager.createQuery("from EmployeeEntity",EmployeeEntity.class);//here in from write pojo entity class name

        //execute a query and get the result list
        List<EmployeeEntity> employees=theQuery.getResultList();

        //return the result list
        return employees;
    }

    @Override
    public EmployeeEntity findById(int theId) {
        //get the employee
        EmployeeEntity theEmployee=entityManager.find(EmployeeEntity.class,theId);

        //return employee
        return theEmployee;
    }

    @Override
    public EmployeeEntity save(EmployeeEntity theEmployee) {
        //save employee
        EmployeeEntity dbEmployee=entityManager.merge(theEmployee);

        //return db employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        //find the employee to delete
        EmployeeEntity theEmployee=entityManager.find(EmployeeEntity.class,theId);

        //remove the employee
        entityManager.remove(theEmployee);

    }

}
