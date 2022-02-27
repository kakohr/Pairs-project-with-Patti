package com.techelevator.dao;

import com.techelevator.model.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDao {

    int createReservation(int siteId, String name, LocalDate fromDate, LocalDate toDate);


    @Override
    public int createReservation(int siteId, String name, LocalDate fromDate, LocalDate toDate) {
        return -1;
    }






//    @Override
//    public void addEmployeeToProject(Long projectID, Long employeeId) {
//        String sql = "INSERT INTO project_employee (project_id, employee_id) VALUES (?, ?);";
//        jdbcTemplate.update(sql, projectID, employeeId);
//    }


}
