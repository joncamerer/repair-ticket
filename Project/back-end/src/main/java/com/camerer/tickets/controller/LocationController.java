package com.camerer.tickets.controller;

import com.camerer.tickets.dao.LocationSqlDAO;
import com.camerer.tickets.exception.LocationNotFoundException;
import com.camerer.tickets.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class LocationController {

    @Autowired
    LocationSqlDAO locationSqlDAO;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/locations", method = RequestMethod.POST)
    public Location create(@Valid @RequestBody Location location) throws LocationNotFoundException {
        return locationSqlDAO.create(location);
    }

    @RequestMapping(path = "/locations", method = RequestMethod.GET)
    public List<Location> listAll() {
        return locationSqlDAO.listAll();
    }

    @RequestMapping(path = "/locations/{id}", method = RequestMethod.GET)
    public Location getLocationById(@PathVariable long id) throws LocationNotFoundException {
        return locationSqlDAO.getLocationById(id);
    }
}
