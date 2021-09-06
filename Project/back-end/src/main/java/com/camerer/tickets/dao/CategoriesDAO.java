package com.camerer.tickets.dao;

import com.camerer.tickets.model.CategoriesDTO;
import com.camerer.tickets.model.EquipmentCategory;
import com.camerer.tickets.model.Position;
import com.camerer.tickets.model.ServiceCategory;

import java.util.List;

public interface CategoriesDAO {

    CategoriesDTO listAll();
    List<Position> listPositions();
    List<EquipmentCategory> listEquipmentCategories();
    List<ServiceCategory> listServiceCategories();
}
