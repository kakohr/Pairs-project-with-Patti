package com.techelevator.dao;

import com.techelevator.model.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcSiteDao implements SiteDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcSiteDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Site> getSitesThatAllowRVs(int parkId) {
     //   List<Site> sites + new ArrayList<>();
      //  String sql = "SELECT"


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



          return new ArrayList<>();
    }

    private Site mapRowToSite(SqlRowSet results) {
        Site site = new Site();
        site.setSiteId(results.getInt("site_id"));
        site.setCampgroundId(results.getInt("campground_id"));
        site.setSiteNumber(results.getInt("site_number"));
        site.setMaxOccupancy(results.getInt("max_occupancy"));
        site.setAccessible(results.getBoolean("accessible"));
        site.setMaxRvLength(results.getInt("max_rv_length"));
        site.setUtilities(results.getBoolean("utilities"));
        return site;
    }
}
