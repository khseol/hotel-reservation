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
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	/**
	 * this will render the page on call of the servlet.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
