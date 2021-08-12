package com.camerer.tickets.dao;

import com.camerer.tickets.exception.TicketNotFoundException;
import com.camerer.tickets.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
    public Ticket create(Ticket ticket) throws TicketNotFoundException {
        String sql = "INSERT INTO ticket (location_id, equipment_id, service_category_id, description, " +
                                         "employee_id, contractor_id, estimate) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
        KeyHolder ticketKey = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] {"ticket_id"});
                ps.setLong(1, ticket.getLocationId());
                ps.setLong(2, ticket.getEquipmentId());
                ps.setLong(3, ticket.getServiceCategoryId());
                ps.setString(4, ticket.getDescription());
                ps.setLong(5, ticket.getEmployeeId());
                ps.setLong(6, ticket.getContractorId());
                ps.setLong(7, ticket.getEstimate());

                return ps;
            }
        }, ticketKey);

        return getTicketById(ticketKey.getKey().longValue());
    }

    @Override
    public List<Ticket> listAll() {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT ticket_id, location_id, equipment_id, service_category_id, description, " +
                            "employee_id, contractor_id, estimate, completed_on, active " +
                        "FROM ticket";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Ticket ticket = mapRowToTicket(results);
            tickets.add(ticket);
        }

        return tickets;
    }

    @Override
    public Ticket getTicketById(long id) throws TicketNotFoundException {
        String sql = "SELECT ticket_id, location_id, equipment_id, service_category_id, description, " +
                            "employee_id, contractor_id, estimate, completed_on, active " +
                        "FROM ticket WHERE ticket_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if (result.next()) {
            return mapRowToTicket(result);
        }

        throw new TicketNotFoundException();
    }

    private Ticket mapRowToTicket(SqlRowSet row) {
        Ticket ticket = new Ticket();

        ticket.setId(row.getLong("ticket_id"));
        ticket.setLocationId(row.getLong("location_id"));
        ticket.setEquipmentId(row.getLong("equipment_id"));
        ticket.setServiceCategoryId(row.getLong("service_category_id"));
        ticket.setDescription(row.getString("description"));
        ticket.setEmployeeId(row.getLong("employee_id"));
        ticket.setContractorId(row.getLong("contractor_id"));
        ticket.setEstimate(row.getLong("estimate"));

        if (row.getTimestamp("completed_on") != null) {
            ticket.setCompletedOn(row.getTimestamp("completed_on").toLocalDateTime());
        }

        ticket.setActive(row.getBoolean("active"));

        return ticket;
    }
}
