package com.skillstorm.reservation.data;

import java.sql.SQLException;
import java.util.List;

import com.skillstorm.reservation.models.User_Information;

/**
 * 
 * @author kathyhseol
 * Basic DAO interface that holds all DAO implementations must have
 * for database access
 * CRUD Logic and the database access credentials.
 *
 */
public interface DAO_Basic {
	
	String url = "jdbc:mysql://localhost:3306/RESERVATION";
	String username ="root";
	String password = "rootPassword1!";
	
	public void save (Object o) throws SQLException;
	public List <Object> find_all ()throws SQLException;
	
	

}
