package com.skillstorm.reservation.service;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.reservation.data.User_Information_DAO_Impl;
import com.skillstorm.reservation.models.User_Information;

/**
 * 
 * @author kathyhseol
 * service class that calls the methods there implemented
 * from the java data package.
 * Class is specifically used for calling the methods in the DAO Impl class
 * for data manipulation of the user accessing the application.
 * User_Information MODEL and the USER_INFORMATION table in the DB.
 *
 */
public class Patron_Service {
	
	User_Information_DAO_Impl patronService = new User_Information_DAO_Impl();
	
	public boolean saveNewUser (User_Information patron) throws SQLException{
		return patronService.save(patron); //the patron object will be type casted when passing through the method execution process.
	}
	
	public List<User_Information> showAllUsers()throws SQLException{
		List<User_Information> allPatrons = patronService.findAllUsers();
		return allPatrons;
		
	}
	
	public boolean updateUser(User_Information patron) throws SQLException{
		return patronService.update(patron);
	}
	public boolean deleteUser(User_Information patron) throws SQLException{
		return patronService.delete(patron);
	}
	
}
