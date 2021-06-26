package com.skillstorm.junit.dao;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import com.skillstorm.reservation.data.User_Information_DAO_Impl;
import com.skillstorm.reservation.models.User_Information;

/**
 * 
 * @author kathyhseol
 * The testing class for the User_Information_DAO_Impl class,
 * testing for the successful implementation and logic of method inside the 
 * Impl class.
 * 
 * 06/25/2021: all CRUD logic ran successful.
 *
 */
public class Test_UserDAO {
	
	static User_Information_DAO_Impl testUser = new User_Information_DAO_Impl();
	
	/**
	 * this method resolves to true when a row has been affected for a save
	 * 
	 * @throws SQLException
	 * result --> success
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
	 * result --> sucess
	 */
	public void retrieve_users() throws SQLException{
		assertEquals(4, testUser.findAll().size()); 
		
	}
	
	/**
	 * test for true when the data base updates information from an 
	 * with the assumption that object is has an id, but had their information changed.
	 * 
	 * results: success
	 */
	public void update_user() throws SQLException {
		User_Information user = new User_Information(4,"Kobe Bryant", "B.legend@outlook.com", 30);
		assertEquals(true, testUser.update(user));
	}
	
	/**
	 * Method that will assert for true for the delete method is successful
	 * the method parameter will probably be changed to an int...lingering thought.
	 * @exception throws an SQLException
	 * result --> success
	 */
	public void delete_user()throws SQLException{
		assertEquals(true,testUser.delete(new User_Information(1)));
	}
}
