package com.skillstorm.reservation.models;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author kathyhseol the POJO that will define the state and behavior of the
 *         reservation system itself. instance variables will include the field
 *         that are required to be in the final reservation product: invoice
 *         number, user name --> through the User_information object user email
 *         user traveling location hotel name --> hotel information will most
 *         probably be grabbed by the user when accessing the User_DAO_Impl to
 *         fill in these fields hotel address number of guest number of rooms
 * 
 *         check in and check out will be coming from SQL as a datetime format:
 *         YYYY-MM-DD hh:mm:ss
 * 			
 * 			this formatting of dates and time will be through the SimpleDateFormat class.			
 * 
 *         total price;
 *
 */

public class Reservation {
	private int reservationID;
	private User_Information userID;
	private Hotel_Information hotelID;
	private Date checkIn;
	private Date checkOut;
	private int numberOfGuests;
	private int numberOfRooms;

	private BigDecimal totalPay;

	public Reservation() {
		super();
	}

	public Reservation(int reservationID) {
		super();
		this.reservationID = reservationID;
	}

	public Reservation(User_Information userID, Hotel_Information hotelID, Date checkIn, Date checkOut,
			int numberOfGuests, int numberOfRooms, BigDecimal totalPay) {
		super();
		this.userID = userID;
		this.hotelID = hotelID;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numberOfGuests = numberOfGuests;
		this.numberOfRooms = numberOfRooms;
		this.totalPay = totalPay;
	}

	public Reservation(int reservationID, User_Information userID, Hotel_Information hotelID, Date checkIn,
			Date checkOut, int numberOfGuests, int numberOfRooms, BigDecimal totalPay) {
		super();
		this.reservationID = reservationID;
		this.userID = userID;
		this.hotelID = hotelID;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numberOfGuests = numberOfGuests;
		this.numberOfRooms = numberOfRooms;
		this.totalPay = totalPay;
	}

	public int getReservationID() {
		return reservationID;
	}

	
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	
	public User_Information getUserID() {
		return userID;
	}

	
	public void setUserID(User_Information userID) {
		this.userID = userID;
	}

	
	public Hotel_Information getHotelID() {
		return hotelID;
	}

	
	public void setHotelID(Hotel_Information hotelID) {
		this.hotelID = hotelID;
	}

	
	public Date getCheckIn() {
		return checkIn;
	}

	
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	
	public Date getCheckOut() {
		return checkOut;
	}

	
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	
	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	
	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	
	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	
	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	
	/**
	 * 
	 * These two methods are special and will need to add validation for these methods so that the 
	 * information being passed through is correct
	 * will also need to access the pricing table through the hotel_information table for accurate results.
	 */
	public BigDecimal getTotalPay() {
		return totalPay;
	}
	public void setTotalPay(BigDecimal totalPay) {
		this.totalPay = totalPay;
	}

	
	/**
	 * a lot of the information will most likely be reflected through the individual objects and their classes.
	 * If more information is needed for reflection of the product, a second toString will be present
	 * and later deleted for finalization.
	 */
	@Override
	public String toString() {
		return "Reservation [reservationID=" + reservationID + ", userID=" + userID + ", hotelID=" + hotelID
				+ ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", numberOfGuests=" + numberOfGuests
				+ ", numberOfRooms=" + numberOfRooms + ", totalPay=" + totalPay + "]";
	}

	
}
