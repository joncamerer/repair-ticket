package com.camerer.tickets.model;

import javax.validation.constraints.NotBlank;

public class Equipment {

    private long id;
    @NotBlank(message = "brand is required")
    private String brand;
    @NotBlank(message = "model is required")
    private String model;
    private String serialNumber;
    private long equipmentCategoryId;
    private long locationId;

    public Equipment() {

    }

    public Equipment(long id, String brand, String model, String serialNumber, long equipmentCategoryId,
                     long locationId) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.equipmentCategoryId = equipmentCategoryId;
        this.locationId = locationId;
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

    public long getEquipmentCategoryId() {
        return equipmentCategoryId;
    }

    public void setEquipmentCategoryId(long equipmentCategoryId) {
        this.equipmentCategoryId = equipmentCategoryId;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }
}
