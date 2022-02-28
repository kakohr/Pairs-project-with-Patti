package com.techelevator.dao;

import com.techelevator.model.Campground;
import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Park>getAllParks() {
        List<Park> parks = new ArrayList<>();
        String sql = "SELECT park_id, name, location, establish_date, area, visitors, description" +
                "FROM park" +
                "ORDER BY location ASC";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
          Park park =mapRowToPark(results);
          parks.add(park);
        }

        return parks;

    }

//    @Override
//    public List<Employee> getAllEmployees() {
//        List<Employee> employees = new ArrayList<>();
//        String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date FROM employee;";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
//        while (results.next()) {
//            Employee employee = mapRowToEmployee(results);
//            employees.add(employee);
//        }
//        return employees;
//    }



//    public List<Campground> getCampgroundsByParkId (List parkId) {
//        List<Campground> campground = new ArrayList<>();
//        String sql = "SELECT park_id, name, open_from_mm, open_to_mm, daily_fee " +
//                "FROM campground" +
//                "ORDER BY park_id";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);
//        while (results.next()) {
//            campground = mapRowToCampground(results);
//            //  campground.add(campground);
//        }
//        return parkId;
//



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


}
