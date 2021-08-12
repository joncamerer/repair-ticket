package com.camerer.tickets.dao;

import com.camerer.tickets.exception.TicketNotFoundException;
import com.camerer.tickets.model.Ticket;

import java.util.List;

public interface TicketDAO {

    Ticket create(Ticket ticket) throws TicketNotFoundException;
    List<Ticket> listAll();
    Ticket getTicketById(long id) throws TicketNotFoundException;
}
