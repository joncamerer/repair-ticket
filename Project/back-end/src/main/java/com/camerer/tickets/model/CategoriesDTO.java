package com.camerer.tickets.model;

import java.util.List;

public class CategoriesDTO {

    private List<Position> positions;
    private List<EquipmentCategory> equipmentCategories;
    private List<ServiceCategory> serviceCategories;

    public CategoriesDTO() {

    }

    public CategoriesDTO(List<Position> positions, List<EquipmentCategory> equipmentCategories,
                         List<ServiceCategory> serviceCategories) {
        this.positions = positions;
        this.equipmentCategories = equipmentCategories;
        this.serviceCategories = serviceCategories;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public List<EquipmentCategory> getEquipmentCategories() {
        return equipmentCategories;
    }

    public void setEquipmentCategories(List<EquipmentCategory> equipmentCategories) {
        this.equipmentCategories = equipmentCategories;
    }

    public List<ServiceCategory> getServiceCategories() {
        return serviceCategories;
    }

    public void setServiceCategories(List<ServiceCategory> serviceCategories) {
        this.serviceCategories = serviceCategories;
    }
}
