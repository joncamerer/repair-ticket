package com.camerer.tickets.dao;

import com.camerer.tickets.model.Address;
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
public class AddressSqlDAO implements AddressDAO {

    private JdbcTemplate jdbcTemplate;

    public AddressSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Address create(Address address) {
        String addressSql = "INSERT INTO address (street_no, street_name, city, state, zip_code) " +
                "VALUES (?, ?, ?, ?, ?)";
        KeyHolder addressKey = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(addressSql, new String[] {"address_id"});
                ps.setLong(1, address.getStreetNumber());
                ps.setString(2, address.getStreetName());
                ps.setString(3, address.getCity());
                ps.setString(4, address.getState());
                ps.setInt(5, address.getZipCode());

                return ps;
            }
        }, addressKey);

        return getAddressById(addressKey.getKey().longValue());
    }

    @Override
    public Address getAddressById(long id) {
        String sql = "SELECT address_id, street_no, street_name, city, state, zip_code " +
                     "FROM address WHERE address_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if (result.next()) {
            return mapRowToAddress(result);
        }

        return null;
    }

    private Address mapRowToAddress(SqlRowSet row) {
        Address address = new Address();

        address.setId(row.getLong("address_id"));
        address.setStreetNumber(row.getLong("street_no"));
        address.setStreetName(row.getString("street_name"));
        address.setCity(row.getString("city"));
        address.setState(row.getString("state"));
        address.setZipCode(row.getInt("zip_code"));

        return address;
    }
}
