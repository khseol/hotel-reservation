package com.skillstorm.reservation.service;


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
	
	public boolean saveReservation(Reservation r){
		return reservation_service.save(r);
	}
	
	public boolean updateReservation(Reservation r){
		return reservation_service.update(r);
	}
	
	public boolean deleteReservation(Reservation r){
		return reservation_service.delete(r);
	}
	
	public List<Reservation> findAllReservations(){
		return reservation_service.findAllReservations();
	}
	
	public Reservation findReservationByID(int id){
		return reservation_service.findByID(id);
	}
}
