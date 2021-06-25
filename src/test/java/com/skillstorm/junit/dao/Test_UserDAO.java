package com.skillstorm.junit.dao;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import com.skillstorm.reservation.data.User_Information_DAO_Impl;
import com.skillstorm.reservation.models.User_Information;

public class Test_UserDAO {
	
	static User_Information_DAO_Impl testUser = new User_Information_DAO_Impl();
	
	/**
	 * this method resolves to true when a row has been affected for a save
	 * 
	 * @throws SQLException
	 */
	
	public void save_user() throws SQLException
	{
		
		User_Information user = new User_Information("John Doe", "jdoe3@gmail.com", 3);
		assertEquals(true, testUser.save(user));
		
	}
	
	/**
	 * for the dummy data that are already inside of the data, test to see if the max size is returned
	 * --> test ran true;
	 * @throws SQLException
	 */
	
	public void retrieve_users() throws SQLException{
		assertEquals(4, testUser.findAll().size()); 
		
	}
	
	/**
	 * test for true when the data base updates information from an existing data.
	 * bcause i have a new object, it didn't have a user_id _yet
	 */
	@Test
	public void update_user() throws SQLException {
		User_Information user = new User_Information("Seto Kaiba", "be.wd@outlook.com", 20); 
		assertEquals(true, testUser.update(user));
	}
	

}
