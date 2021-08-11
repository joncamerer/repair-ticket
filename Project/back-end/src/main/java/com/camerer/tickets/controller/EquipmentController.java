package com.camerer.tickets.controller;

import com.camerer.tickets.dao.EquipmentSqlDAO;
import com.camerer.tickets.exception.EquipmentNotFoundException;
import com.camerer.tickets.model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class EquipmentController {

    @Autowired
    EquipmentSqlDAO equipmentSqlDAO;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/equipment", method = RequestMethod.POST)
    public Equipment create(@Valid @RequestBody Equipment equipment) throws EquipmentNotFoundException {
        return equipmentSqlDAO.create(equipment);
    }

    @RequestMapping(path = "/equipment", method = RequestMethod.GET)
    public List<Equipment> listAll() {
        return equipmentSqlDAO.listAll();
    }

    @RequestMapping(path = "/equipment/{id}", method = RequestMethod.GET)
    public Equipment getEquipmentById(@PathVariable long id) throws EquipmentNotFoundException {
        return equipmentSqlDAO.getEquipmentById(id);
    }
}
