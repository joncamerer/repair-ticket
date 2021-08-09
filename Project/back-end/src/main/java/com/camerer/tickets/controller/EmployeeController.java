package com.camerer.tickets.controller;

import com.camerer.tickets.dao.EmployeeSqlDAO;
import com.camerer.tickets.exception.EmployeeNotFoundException;
import com.camerer.tickets.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeSqlDAO employeeSqlDAO;

    @RequestMapping(path = "/employees/{id}", method = RequestMethod.GET)
    public Employee getByEmployeeId(@PathVariable long id) throws EmployeeNotFoundException {
        return employeeSqlDAO.getEmployeeById(id);
    }
}
