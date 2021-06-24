package com.skillstorm.reservation.data;

/**
 * 
 * @author kathyhseol
 * User_information DAO interface that will define methods that the user
 * will need to define for the use table
 * User will need to define the:
 * name
 * email
 * Traveling location(presented through a natural ordering list
 * 
 * methods:
 * save returns an int on the amount of rows affected.
 * update will need to return void
 * 
 * findBy hotelID will be added to determine which hotel is defined by the specific ID.
 * 
 *
 */
public interface User_InformationDAO {
	
	String url = "jdbc:mysql://localhost:3306/RESERVATION";
	String username ="root";
	String password = "rootPassword1!";
	

}
