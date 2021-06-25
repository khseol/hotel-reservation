package com.skillstorm.reservation.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.skillstorm.reservation.models.User_Information;

public class User_Information_DAO_Impl implements DAO_Basic, AutoCloseable {
	// automatically loads the driver at startup
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private Connection connection;

	public User_Information_DAO_Impl() throws SQLException {
		connect();
	}

	private void connect() throws SQLException {
		// attempt the connection
		connection = DriverManager.getConnection(url, username, password);
	}

	public void save(User_Information user) throws SQLException {
		String sql = "insert into user_information(user_name, user_email, user_travel_location) values (?,?,?)";
		try{
			connect();
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, user.getUser_name());
			stm.setString(2, user.getUser_email());
			stm.setInt(3, user.getTravel_location());
			stm.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public List<User_Information> find_all() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * on the chance that my connection to the data base is not properly closed
	 */
	@Override
	public void close() throws Exception {
		// null checks
		if (connection != null && !connection.isClosed()) {
			this.connection.close();
		}
	}

}