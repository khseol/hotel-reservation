package com.skillstorn.reservation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "hotel-selection", urlPatterns = "/selectHotel")
public class HotelSelection_Servlet extends HttpServlet {

	/**
	 * this method will take in the id of the hotel that the user selected and save it as an object for
	 * the reservation object to use when creating the invoice.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	/**
	 * based on the information provided by user:
	 * if in the same session
	 * the page needs to render a list of hotels that MATCH THE USER'S LOCATION.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp_pages/hotelSelection.jsp").forward(req, resp);
	}
}
