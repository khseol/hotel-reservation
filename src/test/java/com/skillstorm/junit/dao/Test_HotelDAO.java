package com.skillstorm.junit.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.skillstorm.reservation.data.Hotel_Information_DAO_Impl;
import com.skillstorm.reservation.models.Hotel_Information;

public class Test_HotelDAO {

	Hotel_Information_DAO_Impl testHotel = new Hotel_Information_DAO_Impl();
	
	@Test
	public void findAllHotel_Test() throws SQLException {
		List<Hotel_Information> allListedHotels = testHotel.findAllHotel();
		assertEquals(100,allListedHotels.size());
	}
}
