package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcParkDao implements ParkDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

  //  @Override
    public Park getAllParks(int parkId) {
        Park park = null;
        String sql = "SELECT park_id, name, location, establish_date, area, visitors, description" +
                "FROM parks" +
                "WHERE park_id =?;" +
                "ORDER BY park_id ASC";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, getAllParks());
        while (results.next()) {
            park =mapRowToPark(results);
        }

        return park;

    }















    private Park mapRowToPark(SqlRowSet results) {
        Park park = new Park();
        park.setParkId(results.getInt("park_id"));
        park.setName(results.getString("name"));
        park.setLocation(results.getString("location"));
        park.setEstablishDate(results.getDate("establish_date").toLocalDate());
        park.setArea(results.getInt("area"));
        park.setVisitors(results.getInt("visitors"));
        park.setDescription(results.getString("description"));
        return park;
    }

    @Override
    public Park getAllParks() {
        return null;
    }
}
