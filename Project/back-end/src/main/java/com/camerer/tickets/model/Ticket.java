package com.camerer.tickets.model;

public class Ticket {
    private long id;
    private String repairType;
    private boolean active;

    public Ticket() {

    }

    public Ticket(long id, String repairType) {
        this.id = id;
        this.repairType = repairType;
        this.active = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
