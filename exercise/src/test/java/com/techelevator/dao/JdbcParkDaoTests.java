package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JdbcParkDaoTests extends BaseDaoTests {

    private ParkDao dao;

    @Before
    public void setup() {
        dao = new JdbcParkDao(dataSource);
    }

    @Test
    public void getParksTest_Should_ReturnAllParksInLocationAlphaOrder() {
        List<Park> parks = dao.getAllParks();



//        Park park = null;
//        String sql = "SELECT park_id, name, location, establish_date, area, visitors, description" +
//                "FROM park " +
//                "ORDER BY park_id;";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);
//        if (results.next()) {
//            park = mapRowToPark(results);
//        }
//        return park;
//    }












        assertEquals(2, parks.size());
        assertEquals("Ohio", parks.get(0).getLocation());
        assertEquals("Pennsylvania", parks.get(1).getLocation());
    }

}
