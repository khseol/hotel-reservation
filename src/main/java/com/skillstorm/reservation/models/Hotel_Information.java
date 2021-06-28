package com.skillstorm.reservation.models;

import java.math.BigDecimal;

/**
 * the class will contain the available fields already existing inside of the hotel_information table.
 * each object will simply be about setting and getting the information by passing through the object's id.
 * 
 * other constructors are present for future addition of hotels.
 * @author kathyhseol
 *
 */
public class Hotel_Information {

	private int hotelID;
	private String hotelName;
	private int hotelLocationID;
	private String hotelLocationAddress;
	private int hotelType; //this was refactored in the original DB model to differentiate hotel based on their quality level
	private BigDecimal hotelSaleRate; //new field that hold in the sale rates of hotel
	private BigDecimal hotelTaxRate; //new field that will hold in the value of the tax rate of the hotel.
	
	public Hotel_Information() {
		super();
	}

	public Hotel_Information(int hotelID) {
		super();
		this.hotelID = hotelID;
	}

	public Hotel_Information(String hotelName, int hotelLocationID, String hotelLocationAddress, int hotelType) {
		super();
		this.hotelName = hotelName;
		this.hotelLocationID = hotelLocationID;
		this.hotelLocationAddress = hotelLocationAddress;
		this.hotelType = hotelType;
	}

	public Hotel_Information(int hotelID, String hotelName, int hotelLocationID, String hotelLocationAddress,
			int hotelType) {
		super();
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.hotelLocationID = hotelLocationID;
		this.hotelLocationAddress = hotelLocationAddress;
		this.hotelType = hotelType;
	}
	
	

	public Hotel_Information(int hotelID, String hotelName, int hotelLocationID, String hotelLocationAddress,
			int hotelType, BigDecimal hotelSaleRate, BigDecimal hotelTaxRate) {
		super();
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.hotelLocationID = hotelLocationID;
		this.hotelLocationAddress = hotelLocationAddress;
		this.hotelType = hotelType;
		this.hotelSaleRate = hotelSaleRate;
		this.hotelTaxRate = hotelTaxRate;
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getHotelLocationID() {
		return hotelLocationID;
	}

	public void setHotelLocationID(int hotelLocationID) {
		this.hotelLocationID = hotelLocationID;
	}

	public String getHotelLocationAddress() {
		return hotelLocationAddress;
	}

	public void setHotelLocationAddress(String hotelLocationAddress) {
		this.hotelLocationAddress = hotelLocationAddress;
	}

	public int getHotelType() {
		return hotelType;
	}

	public void setHotelType(int hotelType) {
		this.hotelType = hotelType;
	}

	public BigDecimal getHotelSaleRate() {
		System.out.println(hotelSaleRate);
		return hotelSaleRate;
	}

	public void setHotelSaleRate(BigDecimal hotelSaleRate) {
		this.hotelSaleRate = hotelSaleRate;
	}

	public BigDecimal getHotelTaxRate() {
		//System.out.println(hotelTaxRate);
		return hotelTaxRate;
	}

	public void setHotelTaxRate(BigDecimal hotelTaxRate) {
		this.hotelTaxRate = hotelTaxRate;
	}

	@Override
	public String toString() {
		return "Hotel_Information [hotelID=" + hotelID + ", hotelName=" + hotelName + ", hotelLocationID="
				+ hotelLocationID + ", hotelLocationAddress=" + hotelLocationAddress + ", hotelType=" + hotelType
				+ ", hotelSaleRate=" + hotelSaleRate + ", hotelTaxRate=" + hotelTaxRate + "]";
	}

	
	
}
