package com.camerer.tickets.controller;

import com.camerer.tickets.dao.ContractorSqlDAO;
import com.camerer.tickets.exception.ContractorNotFoundException;
import com.camerer.tickets.model.Contractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class ContractorController {

    @Autowired
    ContractorSqlDAO contractorSqlDAO;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/contractors", method = RequestMethod.POST)
    public Contractor create(@Valid @RequestBody Contractor contractor) throws ContractorNotFoundException {
        return contractorSqlDAO.create(contractor);
    }

    @RequestMapping(path = "/contractors", method = RequestMethod.GET)
    public List<Contractor> listAll() {
        return contractorSqlDAO.listAll();
    }

    @RequestMapping(path = "/contractors/{id}", method = RequestMethod.GET)
    public Contractor getContractorById(@PathVariable long id) throws ContractorNotFoundException {
        return contractorSqlDAO.getContractorById(id);
    }
}
