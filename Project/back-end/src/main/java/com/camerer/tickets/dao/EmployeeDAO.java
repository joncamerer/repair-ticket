package com.camerer.tickets.dao;

import com.camerer.tickets.exception.EmployeeNotFoundException;
import com.camerer.tickets.model.Employee;

public interface EmployeeDAO {

    void create(Employee employee);
    Employee getEmployeeById(long id) throws EmployeeNotFoundException;

}
