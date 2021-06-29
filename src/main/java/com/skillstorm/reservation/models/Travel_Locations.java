package com.skillstorm.reservation.models;

/**
 * 
 * @author kathyhseol
 * this is a model for the travel locations that is inisde of the table. 
 * This may or may not be neccessary but for now is used for populating drop-down select in the jsp page.
 */
public class Travel_Locations {

	private int location_id;
	private String stateName;
	
	public Travel_Locations() {
		super();
	}

	public Travel_Locations(int location_id) {
		super();
		this.location_id = location_id;
	}

	public Travel_Locations(int location_id, String stateName) {
		super();
		this.location_id = location_id;
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "Travel_Locations [location_id=" + location_id + ", stateName=" + stateName + "]";
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	
	
}
