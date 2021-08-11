package com.camerer.tickets.dao;

import com.camerer.tickets.model.Position;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class PositionSqlDAO implements PositionDAO {

    private JdbcTemplate jdbcTemplate;

    public PositionSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Position> listAll() {
        List<Position> positions = new ArrayList<>();
        String sql = "SELECT position_id, name FROM position";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Position position = mapRowToPosition(results);
            positions.add(position);
        }

        return positions;
    }

    private Position mapRowToPosition(SqlRowSet row) {
        Position position = new Position();

        position.setId(row.getLong("position_id"));
        position.setName(row.getString("name"));

        return position;
    }
}
