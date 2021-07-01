package com.skillstorm.reservation.service;


import java.util.List;

import com.skillstorm.reservation.data.TravelLocation_DAO_Impl;
import com.skillstorm.reservation.models.Travel_Locations;

public class Travel_Service {

	TravelLocation_DAO_Impl travelService = new TravelLocation_DAO_Impl();
	
	public List<Travel_Locations> listAllLocations(){
		return travelService.listAllLocations();
	}
	
	public Travel_Locations findById (int id){
		return travelService.locationsByID(id);
	}
	
	public Travel_Locations findByName (String stateName){
		return travelService.locationsByName(stateName);
	}
}
