package com.camerer.tickets.dao;

import com.camerer.tickets.exception.LocationNotFoundException;
import com.camerer.tickets.model.Location;

import java.util.List;

public interface LocationDAO {

    Location create(Location location) throws LocationNotFoundException;
    List<Location> listAll();
    Location getLocationById(long id) throws LocationNotFoundException;
}
