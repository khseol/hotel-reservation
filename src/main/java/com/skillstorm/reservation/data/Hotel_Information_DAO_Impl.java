package com.skillstorm.reservation.data;

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
 * @author kathyhseol 
 * 		   DAO class that will will only retrieve information and
 *         store them as objects will also be used to show information based on
 *         certain conditions passed through.
 * 
 *         It probably would have gone faster if i just created a method that
 *         populates ALL of the hotel's fields.
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
	private String password2 = "root"; //password for my desktop delete later for final product
	

	/**
	 * 
	 * @return
	 * the fields are listed as followed: id, name, location,
	 *                      address, type, sale rate and tax rate
	 */
	public List<Hotel_Information> findAllHotels() {
		String sql = "select hotel_information.hotel_id, hotel_information.hotel_name, hotel_information.hotel_location_id, hotel_information.hotel_address_name, hotel_information.hotel_type, pricing.pricing_sale_rate, pricing.pricing_tax_rate from hotel_information\n"
				+ "inner join pricing\n" + "on hotel_information.hotel_type = PRICING.pricing_id;";
		List<Hotel_Information> allHotels = new LinkedList<>();

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Hotel_Information hotel = new Hotel_Information(rs.getInt("hotel_id"), rs.getString("hotel_name"),
						rs.getInt("hotel_location_id"), rs.getString("hotel_address_name"), rs.getInt("hotel_type"),
						rs.getBigDecimal("pricing.pricing_sale_rate"), rs.getBigDecimal("pricing.pricing_tax_rate"));

				allHotels.add(hotel);
			}
		} catch (SQLException e) {
			System.out.println("Something went wrong in findAllHotel method");
			e.printStackTrace();
		}
		//System.out.println(allHotels);
		return allHotels;
	}

	public Hotel_Information findByID(int id) {
		String sql = "select hotel_information.hotel_id, hotel_information.hotel_name, hotel_information.hotel_location_id, hotel_information.hotel_address_name, hotel_information.hotel_type, pricing.pricing_sale_rate, pricing.pricing_tax_rate from hotel_information\n"
				+ "inner join pricing\n" + "on hotel_information.hotel_type = PRICING.pricing_id where hotel_id = ?;";
		Hotel_Information hotel = null;

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				hotel = new Hotel_Information(rs.getInt("hotel_id"), rs.getString("hotel_name"),
						rs.getInt("hotel_location_id"), rs.getString("hotel_address_name"), rs.getInt("hotel_type"),
						rs.getBigDecimal("pricing.pricing_sale_rate"), rs.getBigDecimal("pricing.pricing_tax_rate"));
			}
		} catch (SQLException e) {
			System.out.println("Something went wrong in the findByID hotel method");
			e.printStackTrace();
		}
		return hotel;
	}

	public List<Hotel_Information> findByLocation(int location_id) {
		String sql = "select hotel_information.hotel_id, hotel_information.hotel_name, hotel_information.hotel_location_id, hotel_information.hotel_address_name, hotel_information.hotel_type, pricing.pricing_sale_rate, pricing.pricing_tax_rate from hotel_information\n"
				+ "inner join pricing\n" + "on hotel_information.hotel_type = PRICING.pricing_id where hotel_location_id = ?;";
		List<Hotel_Information> hotels_at = new LinkedList<>();
		Hotel_Information hotel = null;

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, location_id);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				hotel = new Hotel_Information(rs.getInt("hotel_id"), rs.getString("hotel_name"),
						rs.getInt("hotel_location_id"), rs.getString("hotel_address_name"), rs.getInt("hotel_type"),
						rs.getBigDecimal("pricing.pricing_sale_rate"), rs.getBigDecimal("pricing.pricing_tax_rate"));
				
				hotels_at.add(hotel);
			}
		} catch (SQLException e) {
			System.out.println("Something went wrong in the findByLocation hotel method");
			e.printStackTrace();
		}
		return hotels_at;
	}
	
	
	/**
	 * the DAO method that will retrieve the location name of the hotel
	 * this will be based on the hotel's id number.
	 * 
	 * REMNDER: THE USER WILL REFERENCES TRAVEL LOCATION TO THE HOTEL_LOCATION_ID
	 * SO...IN ORDER FOR THE RESERVATION TO HAVE A HOTEL_ID, THE USER WILL ELECT THE HOTEL BASED ON THEIR
	 * TRAVELLING LOCATION, RECEIVED FROM THE CLIENT SIDE.
	 * 
	 */
	public String hotelLocatioName(Hotel_Information hotel) {
		String sql = "select location_state_name from TRAVEL_LOCATION\n" + "inner join hotel_information\n"
				+ "on TRAVEL_LOCATION.location_id = hotel_Information.hotel_location_id\n"
				+ "where hotel_id = ?;";
		String locationName = "";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, hotel.getHotelID());
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				locationName = rs.getString("location_state_name");
			}
		} catch (SQLException e) {
			System.out.println("Something went wrong in hotelLocationName method");
			e.printStackTrace();
		}
		return locationName;
	}

	
}
