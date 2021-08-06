package com.camerer.tickets.dao;

import com.camerer.tickets.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class TicketSqlDAO implements TicketDAO {

    private JdbcTemplate jdbcTemplate;

    public TicketSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Ticket> listAll() {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT tickets_id, repair_type FROM tickets";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Ticket ticket = mapRowToTicket(results);
            tickets.add(ticket);
        }

        return tickets;
    }

    public Ticket mapRowToTicket(SqlRowSet row) {
        Ticket ticket = new Ticket();

        ticket.setId(row.getLong("tickets_id"));
        ticket.setRepairType(row.getString("repair_type"));

        return ticket;
    }
}
