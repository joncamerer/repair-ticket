package com.camerer.tickets.controller;

import com.camerer.tickets.dao.TicketSqlDAO;
import com.camerer.tickets.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    TicketSqlDAO ticketSqlDAO;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/tickets", method = RequestMethod.POST)
    public void create(@RequestBody Ticket ticket) {
        ticketSqlDAO.create(ticket);
    }

    @RequestMapping(path = "/tickets", method = RequestMethod.GET)
    public List<Ticket> listActive() {
        return ticketSqlDAO.listActive();
    }
}
