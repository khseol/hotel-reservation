package com.skillstorm.junit.dao;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;

import org.junit.Test;

import com.skillstorm.reservation.data.Reservation_DAO_Impl;
import com.skillstorm.reservation.models.Hotel_Information;
import com.skillstorm.reservation.models.Reservation;
import com.skillstorm.reservation.models.User_Information;

/**
 * 
 * @author kathyhseol
 * class that will test out the DAO methods in the reservation DAO class to 
 * determine working logic and debugging
 * 
 * Refactoring the reservation model to accept check in and check out as Calendar objects.
 *
 */
public class Test_ReservationDAO {

	Reservation_DAO_Impl testReservation = new Reservation_DAO_Impl();
	/**
	 * 
	 * @throws SQLException
	 * this ran true...when i took out the function for finding total pay....
	 */
	@Test
	public void saveReservatio()throws SQLException{
		//dummy object
		//parameters to take in are--> user id, hotel id, check in, check out, number of guests, number of rooms, total pay
		Calendar reserve_CI = Calendar.getInstance();
		reserve_CI.set(2021, 7, 20, 10, 0, 0);
		Calendar reserve_CO = Calendar.getInstance();
		reserve_CI.set(2021, 7, 25, 8, 0, 0);
		User_Information test_user = new User_Information(3);
		Hotel_Information test_hotel = new Hotel_Information(61);
		
		Reservation testReserve = new Reservation(test_user, test_hotel, reserve_CI, reserve_CO, 2,1); 
		
		assertEquals(true, testReservation.save(testReserve));
	}
}
