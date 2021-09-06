package com.camerer.tickets.controller;

import com.camerer.tickets.dao.CategoriesSqlDAO;
import com.camerer.tickets.model.CategoriesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CategoryController {

    @Autowired
    CategoriesSqlDAO categoriesSqlDAO;

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public CategoriesDTO listAll() {
        return categoriesSqlDAO.listAll();
    }
}
