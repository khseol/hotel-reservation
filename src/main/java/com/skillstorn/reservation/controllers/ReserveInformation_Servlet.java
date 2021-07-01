package com.skillstorn.reservation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "reservation_info", urlPatterns = "/reserve")
public class ReserveInformation_Servlet extends HttpServlet {

	/**
	 * is used for the user to select a dateTime of reservation
	 * number of guest attending, and number of rooms
	 * 
	 * this should then just forward the request to a servlet that will render all information for the user
	 * confirming the details of their reservation
	 * 
	 * important to note that the passed strings will not have a "ss" in their string, so i will need to append a default :00
	 * and convert to calendar.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String checkIn = req.getParameter("checkInTime"); //will be a string that holds the date and time-->needs to be converted.
		String checkOut = req.getParameter("");
		String numOfGuests = req.getParameter("");
		String numOfRooms = req.getParameter("");
	}
	/**
	 * this will render the page on call of the servlet.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.getRequestDispatcher("/jsp_pages/reserve.jsp").forward(req,resp);
	}
}
