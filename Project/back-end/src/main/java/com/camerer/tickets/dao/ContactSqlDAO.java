package com.camerer.tickets.dao;

import com.camerer.tickets.model.Contact;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
@Component
public class ContactSqlDAO implements ContactDAO {

    private JdbcTemplate jdbcTemplate;

    public ContactSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Contact create(Contact contact) {
        String contactSql = "INSERT INTO contact (first_name, last_name, email, phone, address_id) " +
                "VALUES (?, ?, ?, ?, ?)";
        KeyHolder contactKey = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(contactSql, new String[] {"contact_id"});
                ps.setString(1, contact.getFirstName());
                ps.setString(2, contact.getLastName());
                ps.setString(3, contact.getEmail());
                ps.setString(4, contact.getPhone());
                ps.setLong(5, contact.getAddressId());

                return ps;
            }
        }, contactKey);

        return getContactById(contactKey.getKey().longValue());
    }

    @Override
    public Contact getContactById(long id) {
        String sql = "SELECT contact_id, first_name, last_name, email, phone, address_id " +
                     "FROM contact WHERE contact_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if (result.next()) {
            return mapRowToContact(result);
        }

        return null;
    }

    private Contact mapRowToContact(SqlRowSet row) {
        Contact contact = new Contact();

        contact.setId(row.getLong("contact_id"));
        contact.setFirstName(row.getString("first_name"));
        contact.setLastName(row.getString("last_name"));
        contact.setEmail(row.getString("email"));
        contact.setPhone(row.getString("phone"));
        contact.setAddressId(row.getLong("address_id"));

        return contact;
    }
}
