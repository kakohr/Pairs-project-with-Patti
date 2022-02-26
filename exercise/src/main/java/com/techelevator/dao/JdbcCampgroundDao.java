package com.techelevator.dao;

import com.techelevator.model.Campground;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCampgroundDao implements CampgroundDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcCampgroundDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Campground> getCampgroundsByParkId(int parkId) {
        Campground campground = null;
        String sql = "SELECT campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee" +
                "FROM campground" +
                "ORDER BY campground_id";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, campgroundId);
        if (results.next()) {
            campground = mapRowToCampground(results);
        }
        return campground;
    }
    public List<Campground> getCampgroundsByParkId (Long parkId) {
        List<Campground> campgrounds = new ArrayList<>();
        String sql = "SELECT campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee " +
                "FROM campground" +
                "ORDER BY park_id";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, campgroundId);
            while (results.next()) {
                Campground campground = mapRowToCampground(results);
                campground.add(campground);
            }
            return campgrounds;
//    public List<Timesheet> getTimesheetsByEmployeeId(Long employeeId) {
//        List<Timesheet> timesheets = new ArrayList<>();
//        String sql = "SELECT timesheet_id, employee_id, project_id, date_worked," +
//                " hours_worked, billable, description " +
//                "FROM timesheet " +
//                "WHERE employee_id = ? " +
//                "ORDER BY timesheet_id;";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, employeeId);
//        while (results.next()) {
//            Timesheet timesheet = mapRowToTimesheet(results);
//            timesheets.add(timesheet);
//        }
//        return timesheets;
//    }



 //       Timesheet timesheet = null;
//    String sql = "SELECT timesheet_id, employee_id, project_id, date_worked, hours_worked, billable, description " +
//            "FROM timesheet " +
//            "WHERE timesheet_id = ?";
//    SqlRowSet results = jdbcTemplate.queryForRowSet(sql, timesheetId);
//        if (results.next()) {
//        timesheet = mapRowToTimesheet(results);
//    }
//        return timesheet;








        return new ArrayList<>();
    }

    private Campground mapRowToCampground(SqlRowSet results) {
        Campground camp = new Campground();
        camp.setCampgroundId(results.getInt("campground_id"));
        camp.setParkId(results.getInt("park_id"));
        camp.setName(results.getString("name"));
        camp.setOpenFromMonth(results.getInt("open_from_mm"));
        camp.setOpenToMonth(results.getInt("open_to_mm"));
        camp.setDailyFee(results.getDouble("daily_fee"));
        return camp;
    }
}
