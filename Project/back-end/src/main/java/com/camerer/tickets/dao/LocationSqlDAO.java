package com.camerer.tickets.dao;

import com.camerer.tickets.exception.LocationNotFoundException;
import com.camerer.tickets.model.Address;
import com.camerer.tickets.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class LocationSqlDAO implements LocationDAO {

    @Autowired
    AddressSqlDAO addressSqlDAO;

    private JdbcTemplate jdbcTemplate;

    public LocationSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Location create(Location location) throws LocationNotFoundException {
        String sql = "INSERT INTO location (name, address_id) VALUES (?, ?)";
        Address address = new Address(location.getStreetNumber(), location.getStreetName(), location.getCity(),
                                      location.getState(), location.getZipCode());
        long address_id = addressSqlDAO.create(address).getId();
        KeyHolder locationKey = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] {"location_id"});
                ps.setString(1, location.getName());
                ps.setLong(2, address_id);

                return ps;
            }
        }, locationKey);

        return getLocationById(locationKey.getKey().longValue());
    }

    @Override
    public List<Location> listAll() {
        List<Location> locations = new ArrayList<>();
        String sql = "SELECT location_id, name, street_no, street_name, city, state, zip_code " +
                         "FROM location l JOIN address a ON a.address_id = l.address_id";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Location location = mapRowToLocation(results);
            locations.add(location);
        }

        return locations;
    }

    @Override
    public Location getLocationById(long id) throws LocationNotFoundException {
        String sql = "SELECT location_id, name, street_no, street_name, city, state, zip_code " +
                        "FROM location l JOIN address a ON a.address_id = l.address_id " +
                        "WHERE location_id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if(result.next()) {
            return mapRowToLocation(result);
        }

        throw new LocationNotFoundException();
    }

    private Location mapRowToLocation(SqlRowSet row) {
        Location location = new Location();

        location.setId(row.getLong("location_id"));
        location.setName(row.getString("name"));
        location.setStreetNumber(row.getLong("street_no"));
        location.setStreetName(row.getString("street_name"));
        location.setCity(row.getString("city"));
        location.setState(row.getString("state"));
        location.setZipCode(row.getInt("zip_code"));

        return location;
    }
}
