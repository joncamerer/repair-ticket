package com.camerer.tickets.controller;

import com.camerer.tickets.dao.EmployeeSqlDAO;
import com.camerer.tickets.exception.EmployeeNotFoundException;
import com.camerer.tickets.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeSqlDAO employeeSqlDAO;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/employees", method = RequestMethod.POST)
    public Employee create(@Valid @RequestBody Employee employee) throws EmployeeNotFoundException {
        return employeeSqlDAO.create(employee);
    }

    @RequestMapping(path = "/employees", method = RequestMethod.GET)
    public List<Employee> listAll() {
        return employeeSqlDAO.listAll();
    }

    @RequestMapping(path = "/employees/{id}", method = RequestMethod.GET)
    public Employee getByEmployeeId(@PathVariable long id) throws EmployeeNotFoundException {
        return employeeSqlDAO.getEmployeeById(id);
    }
}
