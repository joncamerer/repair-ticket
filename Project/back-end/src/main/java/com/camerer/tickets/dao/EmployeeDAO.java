package com.camerer.tickets.dao;

import com.camerer.tickets.exception.EmployeeNotFoundException;
import com.camerer.tickets.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee create(Employee employee) throws EmployeeNotFoundException;
    List<Employee> listAll();
    Employee getEmployeeById(long id) throws EmployeeNotFoundException;

}
