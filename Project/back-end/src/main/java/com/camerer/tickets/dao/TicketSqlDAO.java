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
    public void create(Ticket ticket) {
        String sql = "INSERT INTO ticket (description) VALUES (?)";

        jdbcTemplate.update(sql, ticket.getDescription());
    }

    @Override
    public List<Ticket> listActive() {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT ticket_id, description, active FROM ticket WHERE active = true";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Ticket ticket = mapRowToTicket(results);
            tickets.add(ticket);
        }

        return tickets;
    }

    private Ticket mapRowToTicket(SqlRowSet row) {
        Ticket ticket = new Ticket();

        ticket.setId(row.getLong("ticket_id"));
        ticket.setDescription(row.getString("description"));
        ticket.setActive(row.getBoolean("active"));

        return ticket;
    }
}
