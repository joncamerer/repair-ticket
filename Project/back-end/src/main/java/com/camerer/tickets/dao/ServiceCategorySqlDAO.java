package com.camerer.tickets.dao;

import com.camerer.tickets.model.ServiceCategory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class ServiceCategorySqlDAO implements ServiceCategoryDAO {

    private JdbcTemplate jdbcTemplate;

    public ServiceCategorySqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ServiceCategory> listAll() {
        List<ServiceCategory> serviceCategories = new ArrayList<>();
        String sql = "SELECT service_category_id, name FROM service_category";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            ServiceCategory serviceCategory = mapRowToServiceCategory(results);
            serviceCategories.add(serviceCategory);
        }

        return serviceCategories;
    }

    private ServiceCategory mapRowToServiceCategory(SqlRowSet row) {
        ServiceCategory serviceCategory = new ServiceCategory();

        serviceCategory.setId(row.getLong("service_category_id"));
        serviceCategory.setName(row.getString("name"));

        return serviceCategory;
    }
}
