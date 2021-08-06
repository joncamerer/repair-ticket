package com.camerer.tickets.model;

public class Ticket {
    private long id;
    private String repairType;

    public Ticket() {

    }

    public Ticket(long id, String repairType) {
        this.id = id;
        this.repairType = repairType;
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
}
