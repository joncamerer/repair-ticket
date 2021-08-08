package com.camerer.tickets.model;

public class Ticket {
    private long id;
    private String description;
    private boolean active;

    public Ticket() {

    }

    public Ticket(long id, String description) {
        this.id = id;
        this.description = description;
        this.active = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
