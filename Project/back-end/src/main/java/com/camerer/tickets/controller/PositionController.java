package com.camerer.tickets.controller;

import com.camerer.tickets.dao.PositionSqlDAO;
import com.camerer.tickets.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PositionController {

    @Autowired
    PositionSqlDAO positionSqlDAO;

    @RequestMapping(path = "/positions", method = RequestMethod.GET)
    public List<Position> listAll() {
        return positionSqlDAO.listAll();
    }
}
