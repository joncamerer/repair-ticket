package com.camerer.tickets.dao;

import com.camerer.tickets.exception.ContractorNotFoundException;
import com.camerer.tickets.model.Address;
import com.camerer.tickets.model.Contact;
import com.camerer.tickets.model.Contractor;
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
public class ContractorSqlDAO implements ContractorDAO {

    @Autowired
    AddressSqlDAO addressSqlDAO;
    @Autowired
    ContactSqlDAO contactSqlDAO;

    private JdbcTemplate jdbcTemplate;

    public ContractorSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Contractor create(Contractor contractor) throws ContractorNotFoundException {
        String sql = "INSERT INTO contractor (contact_id) VALUES (?)";

        Address address = new Address(contractor.getStreetNumber(), contractor.getStreetName(), contractor.getCity(),
                                      contractor.getState(), contractor.getZipCode());
        long addressId = addressSqlDAO.create(address).getId();

        Contact contact = new Contact(contractor.getFirstName(), contractor.getLastName(), contractor.getEmail(),
                                      contractor.getPhone(), addressId);
        long contactId = contactSqlDAO.create(contact).getId();
        KeyHolder contractorKey = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] {"contractor_id"});
                ps.setLong(1, contactId);

                return ps;
            }
        }, contractorKey);

        return getContractorById(contractorKey.getKey().longValue());
    }

    @Override
    public List<Contractor> listAll() {
        List<Contractor> contractors = new ArrayList<>();
        String sql = "SELECT ct.contractor_id, c.first_name, c.last_name, c.email, c.phone, " +
                "a.street_no, a.street_name, a.city, a.state, a.zip_code " +
                "FROM contractor ct " +
                "JOIN contact c ON c.contact_id = ct.contact_id " +
                "JOIN address a ON a.address_id = c.address_id ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Contractor contractor = mapRowToContractor(results);
            String serviceCategorySql = "SELECT service_category_id FROM contractor_service_category " +
                    "WHERE contractor_id = " + contractor.getId();

            contractor.setServiceCategoryIds(jdbcTemplate.queryForList(serviceCategorySql, Long.class));
            contractors.add(contractor);
        }

        return contractors;
    }

    @Override
    public Contractor getContractorById(long id) throws ContractorNotFoundException {
        String contractorSql = "SELECT ct.contractor_id, c.first_name, c.last_name, c.email, c.phone, " +
                            "a.street_no, a.street_name, a.city, a.state, a.zip_code " +
                        "FROM contractor ct " +
                        "JOIN contact c ON c.contact_id = ct.contact_id " +
                        "JOIN address a ON a.address_id = c.address_id " +
                        "WHERE contractor_id = ?";
        String serviceCategorySql = "SELECT service_category_id FROM contractor_service_category " +
                                        "WHERE contractor_id = " + id;

        SqlRowSet contractorResult = jdbcTemplate.queryForRowSet(contractorSql, id);

        if (contractorResult.next()) {
            Contractor thisContractor = mapRowToContractor(contractorResult);
            thisContractor.setServiceCategoryIds(jdbcTemplate.queryForList(serviceCategorySql, Long.class));

            return thisContractor;
        }

        throw new ContractorNotFoundException();
    }

    private Contractor mapRowToContractor(SqlRowSet row) {
        Contractor contractor = new Contractor();

        contractor.setId(row.getLong("contractor_id"));
        contractor.setFirstName(row.getString("first_name"));
        contractor.setLastName(row.getString("last_name"));
        contractor.setEmail(row.getString("email"));
        contractor.setPhone(row.getString("phone"));
        contractor.setStreetNumber(row.getLong("street_no"));
        contractor.setStreetName(row.getString("street_name"));
        contractor.setCity(row.getString("city"));
        contractor.setState(row.getString("state"));
        contractor.setZipCode(row.getInt("zip_code"));

        return contractor;
    }
}
