package com.skillstorm.reservation.data;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import com.skillstorm.reservation.models.Hotel_Information;

/**
 * 
 * @author kathyhseol DAO class that will will only retrieve information and
 *         store them as objects will also be used to show information based on
 *         certain conditions passed through.
 */
public class Hotel_Information_DAO_Impl {

	// load the driver class
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private String url = "jdbc:mysql://localhost:3306/RESERVATION";
	private String username = "root";
	private String password = "rootPassword1!";

	public List<Hotel_Information> findAllHotel() throws SQLException {
		String sql = "select hotel_id, hotel_name, hotel_location_id, hotel_address_name, hotel_type from hotel_information";
		List<Hotel_Information> allHotels = new LinkedList<>();

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Hotel_Information hotel = new Hotel_Information(rs.getInt("hotel_id"), rs.getString("hotel_name"),
						rs.getInt("hotel_location_id"), rs.getString("hotel_address_name"), rs.getInt("hotel_type"));

				allHotels.add(hotel);
			}
		} catch (Exception e) {
			System.out.println("Something went wrong in findAllHotel method");
			e.printStackTrace();
		}
		System.out.println(allHotels);
		return allHotels;
	}

	public List<Hotel_Information> findByID() throws SQLException {
		return null;
	}

	public BigDecimal getSaleRate(Hotel_Information hotel) throws SQLException {
		return null;
	}

	public BigDecimal getTaxRate(Hotel_Information hotel) throws SQLException {
		return null;
	}

	public Hotel_Information getHotelData() throws SQLException {
		return null;
	}

}
