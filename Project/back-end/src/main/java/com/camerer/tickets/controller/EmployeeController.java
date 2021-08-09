package com.camerer.tickets.controller;

import com.camerer.tickets.dao.EmployeeSqlDAO;
import com.camerer.tickets.exception.EmployeeNotFoundException;
import com.camerer.tickets.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeSqlDAO employeeSqlDAO;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/employees/", method = RequestMethod.POST)
    public void create(@RequestBody Employee employee){
        employeeSqlDAO.create(employee);
    }

    @RequestMapping(path = "/employees/{id}", method = RequestMethod.GET)
    public Employee getByEmployeeId(@PathVariable long id) throws EmployeeNotFoundException {
        return employeeSqlDAO.getEmployeeById(id);
    }
}
