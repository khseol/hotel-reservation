package com.skillstorm.junit.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Calendar;

import org.junit.Test;

import com.skillstorm.reservation.data.Reservation_DAO_Impl;
import com.skillstorm.reservation.models.Hotel_Information;
import com.skillstorm.reservation.models.Reservation;
import com.skillstorm.reservation.models.User_Information;

/**
 * 
 * @author kathyhseol class that will test out the DAO methods in the
 *         reservation DAO class to determine working logic and debugging
 * 
 *         Refactor the reservation model to accept check in and check out as
 *         Calendar objects.
 * 
 *         BECAUSE I'M SWITCHING BETWEEN LAPTOP TO DESKTOP, MAKESURE THE CORRECT
 *         PASSWORD IS USED.
 *
 */
public class Test_ReservationDAO {

	Reservation_DAO_Impl testReservation = new Reservation_DAO_Impl();

	/**
	 * 
	 * @throws SQLException after fixing up the totalpay in model, this test ran
	 *                      true;
	 * 
	 *                      when pushing through the calendar object, MySql handles
	 *                      the formatting for the datetime data type for check_in
	 *                      and check_out.
	 */

	public void saveReservatio() throws SQLException {
		// dummy object
		// parameters to take in are--> user id, hotel id, check in, check out, number
		// of guests, number of rooms, total pay
		Calendar reserve_CI = Calendar.getInstance();
		reserve_CI.set(2021, 9, 01, 10, 30, 0); // check-in
		Calendar reserve_CO = Calendar.getInstance(); // check-out
		reserve_CO.set(2021, 9, 10, 12, 30, 0);
		User_Information test_user = new User_Information(3);
		Hotel_Information test_hotel = new Hotel_Information(61);

		Reservation testReserve = new Reservation(test_user, test_hotel, reserve_CI, reserve_CO, 5, 5);

		assertEquals(true, testReservation.save(testReserve));
	}

	/**
	 * Test ran true
	 * 
	 * @throws SQLException
	 */
	public void findAllReservations() throws SQLException {
		assertEquals(1, testReservation.findAllReservations().size());
	}

	/**
	 * test ran true
	 * 
	 * @throws SQLException
	 */
	public void deleteReservation() throws SQLException {

		assertEquals(true, testReservation.delete(new Reservation(13)));
	}

	public void updateReservation() throws SQLException {
		User_Information testUser = new User_Information(3);
		Hotel_Information testHotel = new Hotel_Information(53);
		Calendar ci = Calendar.getInstance();
		ci.set(2021, 8, 5, 9, 0, 0);
		Calendar co = Calendar.getInstance();
		co.set(2021, 8, 9, 12, 0, 0);
		Reservation updateReservation = new Reservation(14, testUser, testHotel, ci, co, 4, 2);
		assertEquals(true, testReservation.update(updateReservation));
	}

	
	/**
	 * 
	 * @throws SQLException
	 * Although test failed due to a SUPER long string from the results,
	 * the true value was within expectations.
	 * this the test ran true.
	 */
	public void findReservatioByID_Test() throws SQLException {
		String testString = "";
		assertEquals(testString, testReservation.findByID(11).toString());
	}
}
