package com.skillstorm.reservation.models;
/**
 * 
 * @author kathyhseol
 * the user information model will be used for user defining qualities
 * from the client server
 * 
 * the model will contain instance variables:
 * user name
 * user email
 * travel location
 * cross referenced hotel information via 
 * inner join on travel location_id, hotel_id where hotel_location_id = ?
 * 
 * this will probably require the making of a hotel model for easier get requests...but who knows.
 * 
 * thinking about taking out the foreign key on the hotel_information since a foreign key won't be needed for an inner join.
 */
public class User_Information {
	
	private int user_id;
	private String user_name;
	private String user_email;
	private int travel_location; //travel location table will contain the state in which hotels reside in....ie will need make
							     //15 out of 50 cases in my switch-case for simplicity.
}
