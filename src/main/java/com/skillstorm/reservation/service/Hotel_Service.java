package com.skillstorm.reservation.service;
/**
 * 
 * @author kathyhseol
 * This is the Hotel service class that will handle all related operations regarding hotel information
 * from the database.
 * methods include:
 * 
 * find all hotels
 * find by id
 * find Hotel location name
 * 
 * all methods ran a test and proved successful in their execution.
 */
import java.util.List;

import com.skillstorm.reservation.data.Hotel_Information_DAO_Impl;
import com.skillstorm.reservation.models.Hotel_Information;

public class Hotel_Service {
	Hotel_Information_DAO_Impl hotel_service = new Hotel_Information_DAO_Impl();
	
	public List<Hotel_Information> getAllHotels(){
		return hotel_service.findAllHotels();
	}

	public Hotel_Information getHotelByID(int id){
		return hotel_service.findByID(id);
	}
	
	public String getHotelLocation(Hotel_Information hotel){
		return hotel_service.hotelLocatioName(hotel);
	}
}
