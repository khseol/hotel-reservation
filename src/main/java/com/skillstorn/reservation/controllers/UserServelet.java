package com.skillstorn.reservation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.reservation.models.User_Information;

@WebServlet(name = "reservation-user", urlPatterns = "/user")
public class UserServelet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User_Information newUser = new User_Information();
		String fullName = req.getParameter("");
		String email = req.getParameter("");
		int travelLocation = Integer.parseInt(req.getParameter(""));
		
		newUser.setUser_name(fullName);
		newUser.setUser_email(email);
		newUser.setTravel_location(travelLocation);
		
		
	}
}
