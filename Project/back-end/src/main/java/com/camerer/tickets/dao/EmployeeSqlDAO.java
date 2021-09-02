package com.camerer.tickets.dao;

import com.camerer.tickets.exception.EmployeeNotFoundException;
import com.camerer.tickets.model.Address;
import com.camerer.tickets.model.Contact;
import com.camerer.tickets.model.Employee;
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
public class EmployeeSqlDAO implements EmployeeDAO {

    @Autowired
    AddressSqlDAO addressSqlDAO;
    @Autowired
    ContactSqlDAO contactSqlDAO;

    private JdbcTemplate jdbcTemplate;

    public EmployeeSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Employee create(Employee employee) throws EmployeeNotFoundException {
        String sql = "INSERT INTO employee (contact_id, position_id, hire_date) " +
                        "VALUES (?, (SELECT position_id FROM position WHERE name = ?), ?)";
        Address address = new Address(employee.getStreetNumber(), employee.getStreetName(), employee.getCity(),
                                      employee.getState(), employee.getZipCode());
        long addressId = addressSqlDAO.create(address).getId();

        Contact contact = new Contact(employee.getFirstName(), employee.getLastName(), employee.getEmail(),
                                      employee.getPhone(), addressId);
        long contactId = contactSqlDAO.create(contact).getId();
        KeyHolder employeeKey = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] {"employee_id"});
                ps.setLong(1, contactId);
                ps.setLong(2, employee.getPositionId());
                ps.setObject(3, employee.getHireDate());

                return ps;
            }
        }, employeeKey);

        return getEmployeeById(employeeKey.getKey().longValue());
    }

    @Override
    public List<Employee> listAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT e.employee_id, c.first_name, c.last_name, c.email, c.phone, a.street_no, a.street_name, " +
                            "a.city, a.state, a.zip_code, e.hire_date, e.position_id " +
                        "FROM employee e " +
                        "JOIN contact c ON c.contact_id = e.contact_id " +
                        "JOIN address a ON a.address_id = c.address_id ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Employee employee = mapRowToEmployee(results);
            String locationsSql = "SELECT location_id FROM employee_location WHERE employee_id = " + employee.getId();

            employee.setLocationIds(jdbcTemplate.queryForList(locationsSql, Long.class));
            employees.add(employee);
        }

        return employees;
    }

    @Override
    public Employee getEmployeeById(long id) throws EmployeeNotFoundException {
        String employeeSql = "SELECT e.employee_id, c.first_name, c.last_name, c.email, c.phone, a.street_no, " +
                                    "a.street_name, a.city, a.state, a.zip_code, e.hire_date, e.position_id " +
                                "FROM employee e " +
                                "JOIN contact c ON c.contact_id = e.contact_id " +
                                "JOIN address a ON a.address_id = c.address_id " +
                                "WHERE employee_id = ?";
        String locationsSql = "SELECT location_id FROM employee_location WHERE employee_id = " + id;

        SqlRowSet result = jdbcTemplate.queryForRowSet(employeeSql, id);

        if (result.next()) {
            Employee employee = mapRowToEmployee(result);
            employee.setLocationIds(jdbcTemplate.queryForList(locationsSql, Long.class));

            return employee;
        }

        throw new EmployeeNotFoundException();
    }

    private Employee mapRowToEmployee(SqlRowSet row) {
        Employee employee = new Employee();

        employee.setId(row.getLong("employee_id"));
        employee.setFirstName(row.getString("first_name"));
        employee.setLastName(row.getString("last_name"));
        employee.setEmail(row.getString("email"));
        employee.setPhone(row.getString("phone"));
        employee.setStreetNumber(row.getLong("street_no"));
        employee.setStreetName(row.getString("street_name"));
        employee.setCity(row.getString("city"));
        employee.setState(row.getString("state"));
        employee.setZipCode(row.getInt("zip_code"));
        employee.setHireDate(row.getDate("hire_date").toLocalDate());
        employee.setPositionId(row.getLong("position_id"));

        return employee;
    }
}
