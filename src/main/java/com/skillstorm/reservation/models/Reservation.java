package com.skillstorm.reservation.models;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

/**
 * 
 * @author kathyhseol
 * the POJO that will define the state and behavior of the reservation system itself.
 * instance variables will include the field that are required to be in the final reservation
 * porduct:
 * invoice number
 * user name --> through the User_information object
 * user email
 * user traveling location
 * hotel name --> hotel information will most probably be grabbed by the user 
 * 				  when accessing the User_DAO_Impl to fill in these fields
 * hotel address
 * number of guest
 * number of rooms
 * 
 * check-in date/time
 * check-out date/time
 * 
 * total price;
 *
 */

public class Reservation {
	private int reserve_id;
	private User_Information patron;
	private int number_of_guest;
	private int number_of_rooms;
	private Date check_in_date;
	private Time check_in_time;
	
	private Date check_out_date;;
	private Time check_out_time;
	
	private BigDecimal totalPrice;
	

}
