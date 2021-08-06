package com.camerer.tickets.controller;

import com.camerer.tickets.dao.TicketSqlDAO;
import com.camerer.tickets.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    TicketSqlDAO ticketSqlDAO;

    @RequestMapping(path = "/tickets", method = RequestMethod.GET)
    public List<Ticket> listAll() {
        return ticketSqlDAO.listAll();
    }
}
