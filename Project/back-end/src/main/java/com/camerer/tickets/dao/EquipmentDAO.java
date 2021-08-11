package com.camerer.tickets.dao;

import com.camerer.tickets.exception.EquipmentNotFoundException;
import com.camerer.tickets.model.Equipment;

import java.util.List;

public interface EquipmentDAO {

    Equipment create(Equipment equipment) throws EquipmentNotFoundException;
    List<Equipment> listAll();
    Equipment getEquipmentById(long id) throws EquipmentNotFoundException;

}
