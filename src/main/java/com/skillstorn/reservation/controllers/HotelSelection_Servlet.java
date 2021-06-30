package com.skillstorn.reservation.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.reservation.models.Hotel_Information;
import com.skillstorm.reservation.models.User_Information;
import com.skillstorm.reservation.service.Hotel_Service;

/**
 * 
 * @author kathyhseol
 *"/jsp_pages/selectHotel" --> for testing
 *
 * future note: the hotel table will be expanded to accommodate a normal distribution of hotels per state.
 */
@WebServlet(name = "hotel-selection", urlPatterns = "/selectHotel")
public class HotelSelection_Servlet extends HttpServlet {

	Hotel_Service hService = new Hotel_Service();//holds the data for the hotel that the user has picked.
	Hotel_Information information = null;//hold information of the hotel and will be passed to the next statge.
	User_Information newUser = null; //will be populated with an existing user from the same session.
	/**
	 * this method will take in the id of the hotel that the user selected and save it as an object for
	 * the reservation object to use when creating the invoice.
	 * this object plus the 
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int hotelID = Integer.parseInt(req.getParameter("selectedHotel"));
		//System.out.println("Selected hotelID: "+ hotelID); //the hotel id was saved.
		information = hService.getHotelByID(hotelID); //THIS DOES NOT GET SAVED TO THE RESERVATION OBJECT YET!
		//forward the session to another jsp page where ask the user to fill out check_in check_out rooms and guest.
		
		req.getSession().setAttribute("newUser",(User_Information)req.getSession().getAttribute("newUser")); //FORWARD THIS TO THE RESERVATIONS TAB.
		req.getSession().setAttribute("hotelInformation", information);
		resp.sendRedirect("reserve");
		
	}
	
	/**
	 * based on the information provided by user:
	 * if in the same session
	 * the page needs to render a list of hotels that MATCH THE USER'S LOCATION.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		newUser = (User_Information)req.getSession().getAttribute("newUser");
		//System.out.println("Hotel servlet user information passed: "+ newUser.toString());
		//what will be populating the web page. COME BACK FOR GRAPHICS AND CLEAN UP
		List<Hotel_Information> availableHotels =hService.findByLocation(newUser.getTravel_location());//needs to take in an integer from the user object...
		req.getSession().setAttribute("listOfHotels", availableHotels); //'name' in the c:foreach will be "listOfHotels"
		req.getRequestDispatcher("/jsp_pages/hotelSelection.jsp").forward(req, resp);
	}

}
