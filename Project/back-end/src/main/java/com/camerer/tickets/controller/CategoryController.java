package com.camerer.tickets.controller;

import com.camerer.tickets.dao.CategoriesSqlDAO;
import com.camerer.tickets.dao.EquipmentCategorySqlDAO;
import com.camerer.tickets.dao.PositionSqlDAO;
import com.camerer.tickets.dao.ServiceCategorySqlDAO;
import com.camerer.tickets.model.CategoriesDTO;
import com.camerer.tickets.model.EquipmentCategory;
import com.camerer.tickets.model.Position;
import com.camerer.tickets.model.ServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {

    @Autowired
    CategoriesSqlDAO categoriesSqlDAO;

    @RequestMapping(path = "/category", method = RequestMethod.GET)
    public CategoriesDTO listAll() {
        return categoriesSqlDAO.listAll();
    }

    @Autowired
    PositionSqlDAO positionSqlDAO;

    @Autowired
    EquipmentCategorySqlDAO equipmentCategorySqlDAO;

    @Autowired
    ServiceCategorySqlDAO serviceCategorySqlDAO;

    @RequestMapping(path = "/positions", method = RequestMethod.GET)
    public List<Position> listPositions() {
        return positionSqlDAO.listAll();
    }

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<EquipmentCategory> listEquipmentCategories() {
        return equipmentCategorySqlDAO.listAll();
    }

    @RequestMapping(path = "/services", method = RequestMethod.GET)
    public List<ServiceCategory> listServiceCategories() {
        return serviceCategorySqlDAO.listAll();
    }
}
