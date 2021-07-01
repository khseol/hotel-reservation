package com.skillstorn.reservation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.reservation.models.Hotel_Information;
import com.skillstorm.reservation.models.Reservation;
import com.skillstorm.reservation.models.User_Information;
import com.skillstorm.reservation.service.Hotel_Service;
import com.skillstorm.reservation.service.Patron_Service;
import com.skillstorm.reservation.service.Reservation_Service;

@WebServlet(name = "reservation_info", urlPatterns = "/reserve")
public class ReserveInformation_Servlet extends HttpServlet {
	Reservation_Service rService = new Reservation_Service();
	Hotel_Service hService = new Hotel_Service();
	Patron_Service pService = new Patron_Service();
	
	/**
	 * is used for the user to select a dateTime of reservation
	 * number of guest attending, and number of rooms
	 * 
	 * this should then just forward the request to a servlet that will render all information for the user
	 * confirming the details of their reservation
	 * 
	 * important to note that the passed strings will not have a "ss" in their string, so i will need to append a default :00
	 * and convert to calendar.
	 * 
	 * format of the date-time if yyyy-mm-ddThh:mm be default, the ss are zeros.
	 * 
	 * future development will make it so that the reservation uses the builder design pattern.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reservation newReservation = new Reservation();
		String checkIn = rService.dateRefactor(req.getParameter("checkInTime")); //will be a string that holds the date and time-->needs to be  refactored and converted.
		String checkOut = rService.dateRefactor(req.getParameter("checkOutTime"));
		int numOfGuests = Integer.parseInt(req.getParameter("guestNumber"));
		int numOfRooms = Integer.parseInt(req.getParameter("roomNumber"));
		
		//System.out.println(checkIn + " " + checkOut + " " + numOfGuests+ " " +numOfRooms); --> for validating the parameters
		newReservation.setCheckIn(newReservation.timeStampToCalendar(checkIn));
		newReservation.setCheckOut(newReservation.timeStampToCalendar(checkOut));
		newReservation.setNumberOfGuests(numOfGuests);
		newReservation.setNumberOfRooms(numOfRooms);
		newReservation.setUserID((User_Information)req.getSession().getAttribute("newUser"));
		newReservation.setHotelID((Hotel_Information)req.getSession().getAttribute("hotelInformation"));
		newReservation.setTotalPay(newReservation.getTotalPay());
		
		System.out.println(newReservation);
		
		//project will assume that the user is placing the reservation without change.
		//in the near future, project will be developed to accommodate changes to the user's information pre and post reservation.
		
		pService.saveNewUser((User_Information)req.getSession().getAttribute("newUser"));
		
		
	}
	/**
	 * this will render the page on call of the servlet.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.getRequestDispatcher("/jsp_pages/reserve.jsp").forward(req,resp);
	}
}
