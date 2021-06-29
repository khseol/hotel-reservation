package com.skillstorm.reservation.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.reservation.models.Reservation;
import com.skillstorm.reservation.service.Hotel_Service;
import com.skillstorm.reservation.service.Patron_Service;

public class Reservation_DAO_Impl implements DAO_Basic {
	// load the driver class
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Couldn't load the driver in reservation DAO");
			e.printStackTrace();
		}
	}

	/**
	 * overridden methods to save the information to the database that has been
	 * passed through from the client-side, to model, to JDBC to the database.
	 * 
	 * returns a boolean value to indicate rows affected in the database.
	 */
	@Override
	public boolean save(Object o) throws SQLException {
		String sql = "insert into reservation_invoice(reserve_user_id, reserve_hotel_id, \n"
				+ "reserve_check_in, reserve_check_out, reserve_number_of_guests, \n"
				+ "reserve_number_of_rooms, reserve_total_pay) \n" + "values (?,?,?,?,?,?,?);";
		int rows = 0;
		try (Connection connection = DriverManager.getConnection(url, username, password)) { // remain a peach color
																								// since obtained from
																								// the interface
			PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			Reservation res = (Reservation) o;
			// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //all
			// ss are going to be floored
			// binding the parameters.
			stm.setObject(1, res.getUserID().getUser_id()); // the set object method is unsure.
			stm.setObject(2, res.getHotelID().getHotelID()); // i am just chaining these together...
			stm.setObject(3, res.getCheckIn());
			stm.setObject(4, res.getCheckOut());
			stm.setInt(5, res.getNumberOfGuests());
			stm.setInt(6, res.getNumberOfRooms());
			stm.setBigDecimal(7, res.getTotalPay());
			// System.out.println("The total expected pay: " + res.getTotalPay());

			rows = stm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Soemthing went wrong in save metod.");
			e.printStackTrace();
		}
		return rows > 0 ? true : false;
	}

	/**
	 * method that should list all existing reservations in the data base.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Reservation> findAllReservations() throws SQLException {
		String sql = "select reserve_id, reserve_user_id, reserve_hotel_id, reserve_check_in, \n"
				+ "reserve_check_out, reserve_number_of_guests, "
				+ "reserve_number_of_rooms, reserve_total_pay from reservation_invoice";
		List<Reservation> allReservations = new LinkedList<>();
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stm.executeQuery();
			// call of the service class for hotel and users for deeper information
			Patron_Service user_service = new Patron_Service();
			Hotel_Service hotel_service = new Hotel_Service();
			while (rs.next()) {
				// the problem is that the model takes in object in the fields.
				Reservation res = new Reservation();
				res.setReservationID(rs.getInt("reserve_id"));
				res.setUserID(user_service.findUserByID(rs.getInt("reserve_user_id")));
				res.setHotelID(hotel_service.getHotelByID(rs.getInt("reserve_hotel_id")));
				res.setCheckIn(res.timeStampToCalendar(rs.getString("reserve_check_in"))); // object type is Calendar
																							// but toString of object
																							// needs to be formatted
																							// using String formatter
				res.setCheckOut(res.timeStampToCalendar(rs.getString("reserve_check_out"))); // this produces the string
																								// format of the
																								// datetime...
				res.setNumberOfGuests(rs.getInt("reserve_number_of_guests"));
				res.setNumberOfRooms(rs.getInt("reserve_number_of_rooms"));
				res.setTotalPay(rs.getBigDecimal("reserve_total_pay")); // the reason to have a set method :)

				allReservations.add(res);
			}
		}
		System.out.println(allReservations);
		return allReservations;
	}

	/**
	 * with the assumption that the user already exist
	 */
	@Override
	public boolean update(Object o) throws SQLException {
		String sql = "update reservation_invoice\r\n"
				+ "set reserve_user_id = ?, reserve_hotel_id = ?, reserve_check_in = ?, \r\n"
				+ "reserve_check_out = ?, reserve_number_of_guests = ?, \r\n"
				+ "reserve_number_of_rooms = ?, reserve_total_pay= ?\r\n" + "where reserve_id = ?";
		int rows = 0;
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			Reservation res = (Reservation) o;
			stm.setObject(1, res.getUserID().getUser_id()); // the set object method is unsure.
			stm.setObject(2, res.getHotelID().getHotelID()); // i am just chaining these together...
			stm.setObject(3, res.getCheckIn());
			stm.setObject(4, res.getCheckOut());
			stm.setInt(5, res.getNumberOfGuests());
			stm.setInt(6, res.getNumberOfRooms());
			stm.setBigDecimal(7, res.getTotalPay());
			stm.setInt(8, res.getReservationID());

			rows = stm.executeUpdate();
		}
		return rows > 0 ? true : false;
	}

	@Override
	public boolean delete(Object o) throws SQLException {
		String sql = "delete from reservation_invoice where reserve_id = ?";
		int rows = 0;
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			Reservation res = (Reservation) o;
			PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stm.setInt(1, res.getReservationID());
			rows = stm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Something went wrong in the delete method.");
			e.printStackTrace();
		}
		return rows > 0 ? true : false;
	}

	/**
	 * method that retreieves the reservation object through an id
	 */
	public Reservation findByID(int id) throws SQLException {
		String sql = "select reserve_id, reserve_user_id, reserve_hotel_id, reserve_check_in, \n"
				+ "reserve_check_out, reserve_number_of_guests, "
				+ "reserve_number_of_rooms, reserve_total_pay from reservation_invoice where reserve_id = ?";
		Reservation invoice = null;
		
		
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			Patron_Service user_service = new Patron_Service();
			Hotel_Service hotel_service = new Hotel_Service();
			while (rs.next()) {
				invoice = new Reservation();
				invoice.setReservationID(rs.getInt("reserve_id"));
				invoice.setUserID(user_service.findUserByID(rs.getInt("reserve_user_id")));
				invoice.setHotelID(hotel_service.getHotelByID(rs.getInt("reserve_hotel_id")));
				invoice.setCheckIn(invoice.timeStampToCalendar(rs.getString("reserve_check_in"))); 
				invoice.setCheckOut(invoice.timeStampToCalendar(rs.getString("reserve_check_out"))); 
				invoice.setNumberOfGuests(rs.getInt("reserve_number_of_guests"));
				invoice.setNumberOfRooms(rs.getInt("reserve_number_of_rooms"));
				invoice.setTotalPay(rs.getBigDecimal("reserve_total_pay")); // the reason to have a set method :)
			}
		} catch (Exception e) {
			System.out.println("Something went wrong in findByID in reservation DAO");
			e.printStackTrace();
		}
		return invoice;
	}

}
