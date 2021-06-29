package com.skillstorm.reservation.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.reservation.models.Travel_Locations;

/**
 *
 * @author kathyhseol
 * sole purpose of this class is to only retrieve data for viewing only. the contents of this class
 * may or may not change depending on the final outcome of the application.
 */
public class TravelLocation_DAO_Impl {
	private String url = "jdbc:mysql://localhost:3306/RESERVATION";
	private String username= "root";
	private String password = "rootPassword1!";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Travel_Locations> listAllLocations(){
		String sql = "Select location_id, location_state_name from TRAVEL_LOCATION";
		List<Travel_Locations> allLocations = new LinkedList<>();
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Travel_Locations location = new Travel_Locations(rs.getInt("location_id"), rs.getString("location_state_name"));
				allLocations.add(location);
			}
			
		}catch (SQLException e) {
			System.out.println("Soemthing went wrong in listAllLocations");
			e.printStackTrace();
		}
		
		return allLocations;
	}
	
	public Travel_Locations locationsByID(int id){
		String sql = "select location_id, location_state_name from TRAVEL_LOCATION where location_id = ?";
		Travel_Locations location = null;
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				location = new Travel_Locations(rs.getInt("location_id"), rs.getString("location_state_name"));
			}
		} catch(SQLException e) {
			System.out.println("Somethng went wrong here in findByID");
		}
		return location;
	}


	public Travel_Locations locationsByName(String stateName){
		String sql = "select location_id, location_state_name from TRAVEL_LOCATION where location_state_name = ?";
		Travel_Locations location = null;
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, stateName);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				location = new Travel_Locations(rs.getInt("location_id"), rs.getString("location_state_name"));
			}
		} catch(SQLException e) {
			System.out.println("Somethng went wrong here in findByName");
		}
		return location;

	}


}
