package com.skillstorm.reservation.service;

import java.sql.SQLException;
import java.util.List;

import com.skillstorm.reservation.data.Reservation_DAO_Impl;
import com.skillstorm.reservation.models.Reservation;

/**
 * 
 * @author kathyhseol
 * The reservation service class that calls the methods from the reservation DAO implementation class
 * from the data package
 *  methods include the CRUD logic data manipulation of the reservation-invoice table in MySQL
 */
public class Reservation_Service {

	Reservation_DAO_Impl reservation_service = new Reservation_DAO_Impl();
	
	public boolean saveReservation(Reservation r) throws SQLException{
		return reservation_service.save(r);
	}
	
	public boolean updateReservation(Reservation r) throws SQLException{
		return reservation_service.update(r);
	}
	
	public boolean deleteReservation(Reservation r) throws SQLException{
		return reservation_service.delete(r);
	}
	
	public List<Reservation> findAllReservations() throws SQLException{
		return reservation_service.findAllReservations();
	}
	
	public Reservation findReservationByID(int id) throws SQLException{
		return reservation_service.findByID(id);
	}
}
