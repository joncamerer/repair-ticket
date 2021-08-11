package com.camerer.tickets.model;

import javax.validation.constraints.NotBlank;

public class Equipment {

    private long id;
    @NotBlank(message = "brand is required")
    private String brand;
    @NotBlank(message = "model is required")
    private String model;
    private String serialNumber;
    private String equipmentCategory;
    private String location;

    public Equipment() {

    }

    public Equipment(long id, String brand, String model, String serialNumber, String equipmentCategory,
                     String location) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.equipmentCategory = equipmentCategory;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getEquipmentCategory() {
        return equipmentCategory;
    }

    public void setEquipmentCategory(String equipmentCategory) {
        this.equipmentCategory = equipmentCategory;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
