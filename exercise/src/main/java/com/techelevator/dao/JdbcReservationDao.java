package com.techelevator.dao;

import com.techelevator.model.Park;
import com.techelevator.model.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;

public class JdbcReservationDao implements ReservationDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcReservationDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int createReservation(int siteId, String name, LocalDate fromDate, LocalDate toDate) {
        String sql = "INSERT INTO reservation (site_id, name, from_date, to_date, create_date) " +
                "VALUES (?, ?, ?, ?, NOW()) RETURNING reservation_id;";
        return jdbcTemplate.queryForObject(sql, Integer.class, siteId, name, fromDate, toDate);

    }

//    @Override
//    public Reservation getAllReservation(int reservationId) {
//      Reservation reservation = null;
//        String sql = "SELECT reservation_id, site_id, name, from_date, to_date, create_date" +
//                "FROM reservation" +
//                "WHERE from_date <= ?" +
//                "ORDER BY from_date";
//
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reservationId());
//        while (results.next()) {
//            reservation = mapRowToReservationId(results);
//        }
//
//        return reservations;






              //  INSERT INTO reservation(site_id, name, from_date, to_date, create_date)
              //  VALUES (1,'Kate Kohr', '04/23/2022', '05/23/2022', '02/27/2022');


    private Reservation mapRowToReservation(SqlRowSet results) {
        Reservation r = new Reservation();
        r.setReservationId(results.getInt("reservation_id"));
        r.setSiteId(results.getInt("site_id"));
        r.setName(results.getString("name"));
        r.setFromDate(results.getDate("from_date").toLocalDate());
        r.setToDate(results.getDate("to_date").toLocalDate());
        r.setCreateDate(results.getDate("create_date").toLocalDate());
        return r;
    }


}
