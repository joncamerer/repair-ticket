package com.camerer.tickets.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class Ticket {
    private long id;
    private long locationId;
    private long equipmentId;
    private long serviceCategoryId;
    private String description;
    private long employeeId;
    private long contractorId;
    private long estimate;
    private LocalDateTime completedOn;
    private boolean active;

    public Ticket() {

    }

    public Ticket(long id, long locationId, long equipmentId, long serviceCategoryId, String description,
                  long employeeId, long contractorId, long estimate, LocalDateTime completedOn, boolean active) {
        this.id = id;
        this.locationId = locationId;
        this.equipmentId = equipmentId;
        this.serviceCategoryId = serviceCategoryId;
        this.description = description;
        this.employeeId = employeeId;
        this.contractorId = contractorId;
        this.estimate = estimate;
        this.completedOn = completedOn;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public long getServiceCategoryId() {
        return serviceCategoryId;
    }

    public void setServiceCategoryId(long serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getContractorId() {
        return contractorId;
    }

    public void setContractorId(long contractorId) {
        this.contractorId = contractorId;
    }

    public long getEstimate() {
        return estimate;
    }

    public void setEstimate(long estimate) {
        this.estimate = estimate;
    }

    public LocalDateTime getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(LocalDateTime completedOn) {
        this.completedOn = completedOn;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
