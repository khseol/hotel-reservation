package com.skillstorm.junit.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

//import org.junit.Test; //this will flash yellow every time i am not in testing

import com.skillstorm.reservation.data.Hotel_Information_DAO_Impl;
import com.skillstorm.reservation.models.Hotel_Information;

public class Test_HotelDAO {

	Hotel_Information_DAO_Impl testHotel = new Hotel_Information_DAO_Impl();
	
	/**
	 * test was successful
	 * @throws SQLException
	 */
	
	public void findAllHotel_Test(){
		List<Hotel_Information> allListedHotels = testHotel.findAllHotels();
		assertEquals(100,allListedHotels.size());
	}
	
	/**
	 * test to determine the logic of the dao function that returns to the user the hotel information
	 * plus hotel pricing information.
	 * @throws SQLException
	 */

	public void findHotelByID_Test(){
		String sampleHotel = "Hotel_Information [hotelID=2, hotelName=Mayer and Sons, hotelLocationID=29, hotelLocationAddress=1603 South Lane, hotelType=1, hotelSaleRate=322.00, hotelTaxRate=17.41]";
		assertEquals(sampleHotel, testHotel.findByID(95).toString());
	}
	
	/**
	 * Test to determine the logic of DAO method to retrieve the Hotel's location name via their id.
	 * test ran successful.
	 * @throws SQLException
	 */
	public void hotelLocationName_Test(){
		Hotel_Information test = new Hotel_Information(7);
		assertEquals("Iowa",testHotel.hotelLocatioName(test));
	}
	
}
