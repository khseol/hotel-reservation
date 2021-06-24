package com.skillstorm.reservation.models;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
 * check-in date/time time format from the sql import: string - time in format "hh:mm:ss" //want to omit the ss...call the toString method.
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
	
	
	private List<Integer> reservationCode = new LinkedList<>();

	public Reservation() {
		super();
	}

	public Reservation(User_Information patron, int number_of_guest, int number_of_rooms, Date check_in_date,
			Time check_in_time, Date check_out_date, Time check_out_time, BigDecimal totalPrice) {
		super();
		this.patron = patron;
		this.number_of_guest = number_of_guest;
		this.number_of_rooms = number_of_rooms;
		this.check_in_date = check_in_date;
		this.check_in_time = check_in_time;
		this.check_out_date = check_out_date;
		this.check_out_time = check_out_time;
		this.totalPrice = totalPrice;
	}

	public int getReserve_id() {
		return reserve_id;
	}

	public void setReserve_id(int reserve_id) {
		this.reserve_id = reserve_id;
	}

	public User_Information getPatron() {
		return patron;
	}

	public void setPatron(User_Information patron) {
		this.patron = patron;
	}

	public int getNumber_of_guest() {
		return number_of_guest;
	}

	public void setNumber_of_guest(int number_of_guest) {
		this.number_of_guest = number_of_guest;
	}

	public int getNumber_of_rooms() {
		return number_of_rooms;
	}

	public void setNumber_of_rooms(int number_of_rooms) {
		this.number_of_rooms = number_of_rooms;
	}

	public Date getCheck_in_date() {
		return check_in_date;
	}

	public void setCheck_in_date(Date check_in_date) {
		this.check_in_date = check_in_date;
	}

	public Time getCheck_in_time() {
		return check_in_time;
	}

	public void setCheck_in_time(Time check_in_time) {
		this.check_in_time = check_in_time;
	}

	public Date getCheck_out_date() {
		return check_out_date;
	}

	public void setCheck_out_date(Date check_out_date) {
		this.check_out_date = check_out_date;
	}

	public Time getCheck_out_time() {
		return check_out_time;
	}

	public void setCheck_out_time(Time check_out_time) {
		this.check_out_time = check_out_time;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/**
	 * 
	 * @return int
	 * method should try and generate a unique random integer that should act like an invoice order.
	 * the reservation id itself could achieve the same thing, but it's sequential.
	 * 
	 * this is in the testing phase for now.
	 */
	public int generateCode() {
		int reserveCode = (int)Math.random();
		do {
			if(reservationCode.contains(reserveCode)) {
				reserveCode = (int)Math.random();
			} else {
				reservationCode.add(reserveCode);
			}
		} while (!reservationCode.contains(reserveCode));
		
		return reserveCode;
	}
	
	@Override
	public String toString() {
		return "Reservation [reserve_id=" + reserve_id + ", patron=" + patron + ", number_of_guest=" + number_of_guest
				+ ", number_of_rooms=" + number_of_rooms + ", check_in_date=" + check_in_date + ", check_in_time="
				+ check_in_time + ", check_out_date=" + check_out_date + ", check_out_time=" + check_out_time
				+ ", totalPrice=" + totalPrice + "]";
	}
	
	
	
	

}
