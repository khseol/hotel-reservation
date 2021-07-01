package com.skillstorm.reservation.models;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;

import com.skillstorm.reservation.service.Hotel_Service;

/**
 * 
 * @author kathyhseol the POJO that will define the state and behavior of the
 *         reservation system itself. instance variables will include the field
 *         that are required to be in the final reservation product: invoice
 *         number, user name --> through the User_information object user email
 *         user traveling location hotel name --> hotel information will most
 *         probably be grabbed by the user when accessing the User_DAO_Impl to
 *         fill in these fields hotel address number of guest number of rooms
 * 
 *         check in and check out will be coming from SQL as a datetime format:
 *         YYYY-MM-DD hh:mm:ss
 * 
 *         this formatting of dates and time will be through the
 *         SimpleDateFormat class.
 * 
 *         total price;
 *
 */

public class Reservation {
	private int reservationID;
	private User_Information userID; // i am not sure how the set object will work out.
	private Hotel_Information hotelID;
	private Calendar checkIn;
	private Calendar checkOut;
	private int numberOfGuests;
	private int numberOfRooms;
	private BigDecimal totalPay;
	private String timeOfDay;

	public Reservation() {
		super();
	}

	public Reservation(int reservationID) {
		super();
		this.reservationID = reservationID;
	}

	public Reservation(User_Information userID, Hotel_Information hotelID, Calendar checkIn, Calendar checkOut,
			int numberOfGuests, int numberOfRooms, BigDecimal totalPay) {
		super();
		this.userID = userID;
		this.hotelID = hotelID;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numberOfGuests = numberOfGuests;
		this.numberOfRooms = numberOfRooms;
		this.totalPay = totalPay;
	}

	/**
	 * 
	 * @param reservationID
	 * @param userID
	 * @param hotelID
	 * @param checkIn
	 * @param checkOut
	 * @param numberOfGuests
	 * @param numberOfRooms
	 * @param totalPay       Constructor for hard coding the fields
	 */
	public Reservation(int reservationID, User_Information userID, Hotel_Information hotelID, Calendar checkIn,
			Calendar checkOut, int numberOfGuests, int numberOfRooms, BigDecimal totalPay) {
		super();
		this.reservationID = reservationID;
		this.userID = userID;
		this.hotelID = hotelID;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numberOfGuests = numberOfGuests;
		this.numberOfRooms = numberOfRooms;
		this.totalPay = totalPay;
	}

	/**
	 * 
	 * @param userID
	 * @param hotelID
	 * @param checkIn
	 * @param checkOut
	 * @param numberOfGuests
	 * @param numberOfRooms  constructor that is used for saving new data
	 */
	public Reservation(User_Information userID, Hotel_Information hotelID, Calendar checkIn, Calendar checkOut,
			int numberOfGuests, int numberOfRooms) {
		super();
		this.userID = userID;
		this.hotelID = hotelID;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numberOfGuests = numberOfGuests;
		this.numberOfRooms = numberOfRooms;
	}

	/**
	 * 
	 * @param reservationID
	 * @param userID
	 * @param hotelID
	 * @param checkIn
	 * @param checkOut
	 * @param numberOfGuests
	 * @param numberOfRooms  Constructor for updating the data
	 */
	public Reservation(int reservationID, User_Information userID, Hotel_Information hotelID, Calendar checkIn,
			Calendar checkOut, int numberOfGuests, int numberOfRooms) {
		super();
		this.reservationID = reservationID;
		this.userID = userID;
		this.hotelID = hotelID;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numberOfGuests = numberOfGuests;
		this.numberOfRooms = numberOfRooms;
	}

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public User_Information getUserID() {
		return userID;
	}

	public void setUserID(User_Information userID) {
		this.userID = userID;
	}

	public Hotel_Information getHotelID() {
		return hotelID;
	}

	public void setHotelID(Hotel_Information hotelID) {
		this.hotelID = hotelID;
	}

	// i will need to pass this method through the converter and return as a string.
	public Calendar getCheckIn() {

		return checkIn;
	}

	public void setCheckIn(Calendar checkIn) {
		this.checkIn = checkIn;
	}

	public Calendar getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Calendar checkOut) {
		this.checkOut = checkOut;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	/**
	 * 
	 * Fixed up the calculations to retrieve total pay. debating over the fact to
	 * keep setTotalPay method...
	 */
	public BigDecimal getTotalPay() {
		Hotel_Service hotelInfo = new Hotel_Service();
		Hotel_Information sample = hotelInfo.getHotelByID(hotelID.getHotelID());
		BigDecimal subtotal = sample.getHotelSaleRate().multiply(new BigDecimal(numberOfRooms));
		BigDecimal taxBy1h = sample.getHotelTaxRate().divide(new BigDecimal(100));

		totalPay = subtotal.add(subtotal.multiply(taxBy1h));
		return totalPay;
	}

	public void setTotalPay(BigDecimal totalPay) {
		this.totalPay = totalPay;
	}

	/**
	 * a lot of the information will most likely be reflected through the individual
	 * objects and their classes. If more information is needed for reflection of
	 * the product, a second toString will be present and later deleted for
	 * finalization.
	 * 
	 * the calendar object will need to have a method that will turn to datetime
	 * format, not object address.
	 */
	@Override
	public String toString() {
		return "Reservation [reservationID=" + reservationID + ",\nuserID=" + userID + ",\nhotelID=" + hotelID
				+ ",\ncheckIn=" + this.calenderToString(checkIn) + ",\ncheckOut=" + this.calenderToString(checkOut)
				+ ",\nnumberOfGuests=" + numberOfGuests + ",\nnumberOfRooms=" + numberOfRooms + ", \ntotalPay="
				+ totalPay + "]";
	}

	//this is the problem where it is incrementing my months by one for some reason.
	public String calenderToString(Calendar date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // characters must me different
		//System.out.println("inside simpleDateFormatter: " + formatter.format(date.getTime()));
		return (formatter.format(date.getTime())) + timeOfDay;
	}

	/**
	 * method that will be used to convert the string of the date time format to a
	 * calendar format. as a string in the form of YYYY-MM-DD hh:mm:ss i will need a
	 * tokenizer to separate the various fields in the format
	 * 
	 * i need to figure out why this is returning the address of the calendar
	 * class....
	 * 
	 * @param dateTime
	 * @return
	 */
	public Calendar timeStampToCalendar(String dateTime) {
		// parse tokenized string to their respective integer
		// timestamp is format as yyyy-mm-dd HH:mm:SS
		Calendar cDateTime = Calendar.getInstance();
		StringTokenizer date_time = new StringTokenizer(dateTime, " "); // separates the string as two separate string
		String date = date_time.nextToken(); // holds the date in yyyy-mm-dd
		String time = date_time.nextToken(); // holds the time in hh:mm:ss;

		date_time = new StringTokenizer(date, "-");
		String year = date_time.nextToken();
		String month = date_time.nextToken();

		String day = date_time.nextToken();

		date_time = new StringTokenizer(time, ":");
		String hour = date_time.nextToken();
		if (Integer.parseInt(hour) > 12) { // checks for maritime
			hour = String.valueOf(Integer.parseInt(hour) - 12); // difference is the time in 1-12hr pattern
			this.timeOfDay(false);
		} else {
			this.timeOfDay(true);
		}
		String minute = date_time.nextToken();
		cDateTime.set(Integer.parseInt(year), (Integer.parseInt(month) - 1), Integer.parseInt(day),
				Integer.parseInt(hour), Integer.parseInt(minute), 0);

		return cDateTime;
	}

	public String timeOfDay(boolean am) {
		if (am == true) {
			this.timeOfDay = "AM";
		} else if (am == false) { // want to make sure...
			this.timeOfDay = "PM";
		}
		return timeOfDay;
	}

}
