package com.skillstorm.reservation.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author kathyhseol
 * an abstract class that comes with methods that implemented methods for CRUD 
 * operations.
 * 
 * the methods will require the objects to be casted to their respective type;
 */

abstract class DAO_Basic {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	String url = "jdbc:mysql://localhost:3306:RESERVATION";
	String username = "root";
	String password = "rootPassword1!";
	protected Connection connection;
	
	//CONNECTION
	public void connect()throws SQLException {
		connection = DriverManager.getConnection(url, username, password);
	}
	
	//CREATE 
	abstract void save(Object o) throws SQLException;
	
	
	//RETRIEVE
	abstract List<Object> findAll() throws SQLException;
	
	//UPDATE
	abstract void update(Object o) throws SQLException;
	
	//DELETE
	abstract void delete (Object o) throws SQLException;

}
