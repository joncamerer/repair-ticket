package com.camerer.tickets.dao;

import com.camerer.tickets.exception.EmployeeNotFoundException;
import com.camerer.tickets.model.Employee;
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
public class EmployeeSqlDAO implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    public EmployeeSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Employee employee) {
        String addressSql = "INSERT INTO address (street_no, street_name, city, state, zip_code) " +
                                "VALUES (?, ?, ?, ?, ?)";
        String contactSql = "INSERT INTO contact (first_name, last_name, email, phone, address_id) " +
                                "VALUES (?, ?, ?, ?, ?)";
        String employeeSql = "INSERT INTO employee (contact_id, position_id, hire_date) VALUES (?, " +
                                "(SELECT position_id FROM position WHERE name = ?), ?)";

        KeyHolder addressKey = new GeneratedKeyHolder();
        KeyHolder contactKey = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(addressSql, new String[] {"address_id"});
                ps.setLong(1, employee.getStreetNumber());
                ps.setString(2, employee.getStreetName());
                ps.setString(3, employee.getCity());
                ps.setString(4, employee.getState());
                ps.setInt(5, employee.getZip_code());

                return ps;
            }
        }, addressKey);

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(contactSql, new String[] {"contact_id"});
                ps.setString(1, employee.getFirstName());
                ps.setString(2, employee.getLastName());
                ps.setString(3, employee.getEmail());
                ps.setString(4, employee.getPhone());
                ps.setInt(5, addressKey.getKey().intValue());

                return ps;
            }
        }, contactKey);

        jdbcTemplate.update(employeeSql,
                            contactKey.getKey().intValue(), employee.getPosition(), employee.getHireDate());
    }

    @Override
    public Employee getEmployeeById(long id) throws EmployeeNotFoundException {
        String sql = "SELECT c.first_name, c.last_name, c.email, c.phone, a.street_no, a.street_name, " +
                            "a.city, a.state, a.zip_code, e.hire_date, p.name AS position " +
                        "FROM employee e " +
                        "JOIN contact c ON c.contact_id = e.contact_id " +
                        "JOIN address a ON a.address_id = c.address_id " +
                        "JOIN position p ON p.position_id = e.position_id " +
                        "WHERE employee_id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if (result.next()) {
            Employee employee = mapRowToEmployee(result);
            employee.setId(id);

            return employee;
        }

        throw new EmployeeNotFoundException();
    }

    public Employee mapRowToEmployee(SqlRowSet row) {
        Employee employee = new Employee();

        employee.setFirstName(row.getString("first_name"));
        employee.setLastName(row.getString("last_name"));
        employee.setEmail(row.getString("email"));
        employee.setPhone(row.getString("phone"));
        employee.setStreetNumber(row.getLong("street_no"));
        employee.setStreetName(row.getString("street_name"));
        employee.setCity(row.getString("city"));
        employee.setState(row.getString("state"));
        employee.setZip_code(row.getInt("zip_code"));
        employee.setHireDate(row.getDate("hire_date"));
        employee.setPosition(row.getString("position"));

        return employee;
    }
}
