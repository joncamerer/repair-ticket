package com.camerer.tickets.controller;

import com.camerer.tickets.dao.TicketSqlDAO;
import com.camerer.tickets.exception.TicketNotFoundException;
import com.camerer.tickets.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TicketController {

    @Autowired
    TicketSqlDAO ticketSqlDAO;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/tickets", method = RequestMethod.POST)
    public Ticket create(@RequestBody Ticket ticket) throws TicketNotFoundException {

        return ticketSqlDAO.create(ticket);
    }

    @RequestMapping(path = "/tickets", method = RequestMethod.GET)
    public List<Ticket> listAll() {
        return ticketSqlDAO.listAll();
    }

    @RequestMapping(path = "/tickets/{id}", method = RequestMethod.GET)
    public Ticket getTicketById(@PathVariable long id) throws TicketNotFoundException {
        return ticketSqlDAO.getTicketById(id);
    }
}
