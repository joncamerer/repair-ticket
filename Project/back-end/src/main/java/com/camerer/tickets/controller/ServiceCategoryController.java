package com.camerer.tickets.controller;

import com.camerer.tickets.dao.ServiceCategorySqlDAO;
import com.camerer.tickets.model.ServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ServiceCategoryController {

    @Autowired
    ServiceCategorySqlDAO serviceCategorySqlDAO;

    @RequestMapping(path = "/services", method = RequestMethod.GET)
    public List<ServiceCategory> listAll() {
        return serviceCategorySqlDAO.listAll();
    }
}
