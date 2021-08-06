package com.camerer.tickets.dao;

import com.camerer.tickets.model.Ticket;

import java.util.List;

public interface TicketDAO {

    void create(Ticket ticket);
    List<Ticket> listActive();
}
