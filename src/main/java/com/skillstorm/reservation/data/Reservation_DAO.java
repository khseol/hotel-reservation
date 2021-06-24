package com.skillstorm.reservation.data;

import com.skillstorm.reservation.models.Reservation;

/**
 * 
 * @author kathyhseol
 * the Reservation interface will define methods needed to access
 * the necessary tables: user_information, hotel_information(while will also refer to pricing)
 * 
 * methods contained in interface will be:
 * save method --> return type is int
 * update method --> to update any information that was filled out wrongly return type is void
 * Retrieve method --> return type is the reservation model object
 * 						should be able to retrieve the necessary information from the connected tables
 * 						and set those values to the model
 * 
 * maybe a delete method in case the user decides to change information or delete
 * 
 * the information will most likely need to DISABLE AUTO_COMMITS and set isolations levels for
 * some whole transactions to occur
 *
 */
public interface Reservation_DAO {
	
	String url = "jdbc:mysql://localhost:3306/RESERVATION";
	String username ="root";
	String password = "rootPassword1!";
	
	public int save(Reservation reserve);
	
		

}
