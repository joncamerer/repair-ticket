package com.camerer.tickets.dao;

import com.camerer.tickets.exception.EmployeeNotFoundException;
import com.camerer.tickets.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class EmployeeSqlDAO implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    public EmployeeSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
