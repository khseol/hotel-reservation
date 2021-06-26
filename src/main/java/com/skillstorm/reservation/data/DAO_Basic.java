package com.skillstorm.reservation.data;

import java.sql.SQLException;
import java.util.List;

import com.skillstorm.reservation.models.User_Information;

/**
 * 
 * @author kathyhseol an abstract class that comes with methods that implemented
 *         methods for CRUD operations.
 * 
 *         the methods will require the objects to be casted to their respective
 *         type;
 */

public interface DAO_Basic {

	String url = "jdbc:mysql://localhost:3306/RESERVATION";
	String username = "root";
	String password = "rootPassword1!";

	// CREATE
	public boolean save(Object o) throws SQLException;

	// RETRIEVE -- will probably need to add more retrieve options.
	public List<User_Information> findAll() throws SQLException;

	// UPDATE
	public boolean update(Object o) throws SQLException;

	// DELETE
	public boolean delete(Object o) throws SQLException;

}
