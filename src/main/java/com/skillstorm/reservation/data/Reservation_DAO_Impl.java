package com.skillstorm.reservation.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.skillstorm.reservation.models.Reservation;
import com.skillstorm.reservation.models.User_Information;


public class Reservation_DAO_Impl implements DAO_Basic{
	//load the driver class
	static {
		try {Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Couldn't load the driver in reservation DAO");
			e.printStackTrace();
		}
	}

	/**
	 * overridden methods to save the information to the database that has been passed through from the 
	 * client-side, to model, to JDBC to the database.
	 * 
	 * returns a boolean value to indicate rows affected in the database.
	 */
	@Override
	public boolean save(Object o) throws SQLException {
		String sql = "insert into reservation_invoice(reserve_user_id, reserve_hotel_id, \n"
				+ "reserve_check_in, reserve_check_out, reserve_number_of_guests, \n"
				+ "reserve_number_of_rooms, reserve_total_pay) \n"
				+ "values (?,?,?,?,?,?,?);";
		int rows = 0;
		try(Connection connection = DriverManager.getConnection(url, username, password)){ //remain a peach color since obtained from the interface
			PreparedStatement stm = connection.prepareStatement(sql);
			Reservation res = (Reservation)o;
			//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //all ss are going to be floored
			//binding the parameters.
			stm.setObject(1, res.getUserID().getUser_id()); //the set object method is unsure.
			stm.setObject(2, res.getHotelID().getHotelID()); //i am just chaining these together...
			stm.setObject(3, res.getCheckIn());
			stm.setObject(4, res.getCheckOut());
			stm.setInt(5, res.getNumberOfGuests());
			stm.setInt(6, res.getNumberOfRooms());
			stm.setBigDecimal(7, res.getTotalPay());
			System.out.println("The total expected pay: " + res.getTotalPay());
			
			rows = stm.executeUpdate();
		}catch (Exception e) {
			System.out.println("Soemthing went wrong in save metod.");
			e.printStackTrace();
		}
		return rows>0? true:false;
	}

	@Override
	public List<User_Information> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Object o) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object o) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
