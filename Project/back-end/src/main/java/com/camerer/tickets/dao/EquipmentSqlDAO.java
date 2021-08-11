package com.camerer.tickets.dao;

import com.camerer.tickets.exception.EquipmentNotFoundException;
import com.camerer.tickets.model.Equipment;
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
public class EquipmentSqlDAO implements EquipmentDAO {

    private JdbcTemplate jdbcTemplate;

    public EquipmentSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Equipment create(Equipment equipment) throws EquipmentNotFoundException {
        String sql = "INSERT INTO equipment (brand, model, serial_no, equipment_category_id, location_id) " +
                        "VALUES (?, ?, ?, (SELECT equipment_category_id FROM equipment_category WHERE name = ?), " +
                                         "(SELECT location_id FROM location WHERE name = ?))";
        KeyHolder equipmentKey = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] {"equipment_id"});
                ps.setString(1, equipment.getBrand());
                ps.setString(2, equipment.getModel());
                ps.setString(3, equipment.getSerialNumber());
                ps.setString(4, equipment.getEquipmentCategory());
                ps.setString(5, equipment.getLocation());

                return ps;
            }
        }, equipmentKey);

        return getEquipmentById(equipmentKey.getKey().longValue());
    }

    @Override
    public List<Equipment> listAll() {
        List<Equipment> equipment = new ArrayList<>();
        String sql = "SELECT equipment_id, brand, model, serial_no, " +
                            "ec.name AS equipment_category, l.name AS location " +
                        "FROM equipment e " +
                        "JOIN equipment_category ec ON ec.equipment_category_id = e.equipment_category_id " +
                        "JOIN location l ON l.location_id = e.location_id";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Equipment thisEquipment = mapRowToEquipment(results);
            equipment.add(thisEquipment);
        }

        return equipment;
    }

    @Override
    public Equipment getEquipmentById(long id) throws EquipmentNotFoundException {
        String sql = "SELECT equipment_id, brand, model, serial_no, " +
                            "ec.name AS equipment_category, l.name AS location " +
                        "FROM equipment e " +
                        "JOIN equipment_category ec ON ec.equipment_category_id = e.equipment_category_id " +
                        "JOIN location l ON l.location_id = e.location_id " +
                        "WHERE equipment_id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if (result.next()) {
            return mapRowToEquipment(result);
        }

        throw new EquipmentNotFoundException();
    }

    private Equipment mapRowToEquipment(SqlRowSet row) {
        Equipment equipment = new Equipment();

        equipment.setId(row.getLong("equipment_id"));
        equipment.setBrand(row.getString("brand"));
        equipment.setModel(row.getString("model"));
        equipment.setSerialNumber(row.getString("serial_no"));
        equipment.setEquipmentCategory(row.getString("equipment_category"));
        equipment.setLocation(row.getString("location"));

        return equipment;
    }
}
