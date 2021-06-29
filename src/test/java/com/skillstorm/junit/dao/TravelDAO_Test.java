package com.skillstorm.junit.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.skillstorm.reservation.data.TravelLocation_DAO_Impl;

public class TravelDAO_Test {
	// TODO Auto-generated constructor stub
	TravelLocation_DAO_Impl testDao = new TravelLocation_DAO_Impl();
	
	
	
	public void findallTest() {
		assertEquals(50, testDao.listAllLocations().size());
	}
}
