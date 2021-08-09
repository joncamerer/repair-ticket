package com.camerer.tickets.dao;

import com.camerer.tickets.exception.EmployeeNotFoundException;
import com.camerer.tickets.model.Employee;

public interface EmployeeDAO {

    Employee getEmployeeById(long id) throws EmployeeNotFoundException;

}
