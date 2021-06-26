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
	private int travel_location;
	
	public User_Information() {
		super();
	}
	
	/**
	 * 
	 * @param user_id
	 * constructor is in the stages of testing.
	 * Constructor is used to find the existing data,
	 * and set the properties of the object...
	 */
	public User_Information(int user_id) {
		super();
		this.user_id = user_id;
	}

	public User_Information(String user_name, String user_email, int travel_location) {
		super();
		this.user_name = user_name;
		this.user_email = user_email;
		this.travel_location = travel_location;
	}

	public User_Information(int user_id, String user_name, String user_email, int travel_location) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.travel_location = travel_location;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public int getTravel_location() {
		return travel_location;
	}

	public void setTravel_location(int travel_location) {
		this.travel_location = travel_location;
	}

	@Override
	public String toString() {
		return "User_Information [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email
				+ ", travel_location=" + travel_location + "]";
	}
	
	
								
	
}
