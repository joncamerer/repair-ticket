package com.camerer.tickets.dao;

import com.camerer.tickets.model.EquipmentCategory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class EquipmentCategorySqlDAO implements EquipmentCategoryDAO {

    private JdbcTemplate jdbcTemplate;

    public EquipmentCategorySqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<EquipmentCategory> listAll() {
        List<EquipmentCategory> equipmentCategories = new ArrayList<>();
        String sql = "SELECT equipment_category_id, name FROM equipment_category";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            EquipmentCategory equipmentCategory = mapRowToEquipmentCategory(results);
            equipmentCategories.add(equipmentCategory);
        }

        return equipmentCategories;
    }

    private EquipmentCategory mapRowToEquipmentCategory(SqlRowSet row) {
        EquipmentCategory equipmentCategory = new EquipmentCategory();

        equipmentCategory.setId(row.getLong("equipment_category_id"));
        equipmentCategory.setName(row.getString("name"));

        return equipmentCategory;
    }
}
