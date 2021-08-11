package com.camerer.tickets.controller;

import com.camerer.tickets.dao.EquipmentCategorySqlDAO;
import com.camerer.tickets.model.EquipmentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class EquipmentCategoryController {

    @Autowired
    EquipmentCategorySqlDAO equipmentCategorySqlDAO;

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<EquipmentCategory> listAll() {
        return equipmentCategorySqlDAO.listAll();
    }
}
