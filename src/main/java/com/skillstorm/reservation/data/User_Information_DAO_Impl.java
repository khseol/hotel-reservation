package com.skillstorm.reservation.data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.skillstorm.reservation.models.User_Information;

public class User_Information_DAO_Impl extends DAO_Basic implements AutoCloseable {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void close() throws Exception {
		// null checks
		if (connection != null && !connection.isClosed()) {
			this.connection.close();
		}
	}



	@Override
	void save(Object o) throws SQLException {
		//String for inserting new user data into data base
		String sql = "Insert into USER_INFORMATION (user_name, user_email, user_travel_location)";
		try {
			connect();
			PreparedStatement stm = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			User_Information user = (User_Information) o; //casted the object to user_information object
			
			stm.setString(1, user.getUser_name());
			stm.setString(2, user.getUser_email());
			stm.setInt(3, user.getTravel_location());
			
			stm.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}



	@Override
	List<Object> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	void update(Object o) throws SQLException {
		// TODO Auto-generated method stub
		
	}



	@Override
	void delete(Object o) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}