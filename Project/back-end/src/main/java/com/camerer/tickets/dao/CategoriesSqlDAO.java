package com.camerer.tickets.dao;

import com.camerer.tickets.model.CategoriesDTO;
import com.camerer.tickets.model.EquipmentCategory;
import com.camerer.tickets.model.Position;
import com.camerer.tickets.model.ServiceCategory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class CategoriesSqlDAO implements CategoriesDAO {

    private JdbcTemplate jdbcTemplate;

    public CategoriesSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public CategoriesDTO listAll() {
        CategoriesDTO categoriesDTO = new CategoriesDTO();

        categoriesDTO.setPositions(listPositions());
        categoriesDTO.setEquipmentCategories(listEquipmentCategories());
        categoriesDTO.setServiceCategories(listServiceCategories());

        return categoriesDTO;
    }

    private List<Position> listPositions() {
        List<Position> positions = new ArrayList<>();
        String sql = "SELECT position_id, name FROM position";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Position position = mapRowToPosition(results);
            positions.add(position);
        }

        return positions;
    }

    private List<EquipmentCategory> listEquipmentCategories() {
        List<EquipmentCategory> equipmentCategories = new ArrayList<>();
        String sql = "SELECT equipment_category_id, name FROM equipment_category";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            EquipmentCategory equipmentCategory = mapRowToEquipmentCategory(results);
            equipmentCategories.add(equipmentCategory);
        }

        return equipmentCategories;
    }

    private List<ServiceCategory> listServiceCategories() {
        List<ServiceCategory> serviceCategories = new ArrayList<>();
        String sql = "SELECT service_category_id, name FROM service_category";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            ServiceCategory serviceCategory = mapRowToServiceCategory(results);
            serviceCategories.add(serviceCategory);
        }

        return serviceCategories;
    }

    private Position mapRowToPosition(SqlRowSet row) {
        Position position = new Position();

        position.setId(row.getLong("position_id"));
        position.setName(row.getString("name"));

        return position;
    }

    private EquipmentCategory mapRowToEquipmentCategory(SqlRowSet row) {
        EquipmentCategory equipmentCategory = new EquipmentCategory();

        equipmentCategory.setId(row.getLong("equipment_category_id"));
        equipmentCategory.setName(row.getString("name"));

        return equipmentCategory;
    }

    private ServiceCategory mapRowToServiceCategory(SqlRowSet row) {
        ServiceCategory serviceCategory = new ServiceCategory();

        serviceCategory.setId(row.getLong("service_category_id"));
        serviceCategory.setName(row.getString("name"));

        return serviceCategory;
    }
}
