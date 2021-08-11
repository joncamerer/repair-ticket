package com.camerer.tickets.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class Location {

    private long id;
    @NotBlank(message = "location name is required")
    private String name;
    @Positive(message = "street number is required")
    private long streetNumber;
    @NotBlank(message = "street name is required")
    private String streetName;
    @NotBlank(message = "city is required")
    private String city;
    @NotBlank(message = "state is required")
    private String state;
    @Positive(message = "zip code is required")
    private int zipCode;

    public Location() {

    }

    public Location(long id, String name, long streetNumber, String streetName, String city, String state, int zipCode) {
        this.id = id;
        this.name = name;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(long streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
