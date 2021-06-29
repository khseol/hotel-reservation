package com.skillstorn.reservation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.reservation.models.User_Information;
import com.skillstorm.reservation.service.Patron_Service;

@WebServlet(name = "reservation-user", urlPatterns = "/user")
public class UserServelet extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User_Information newUser = new User_Information();
		String fullName = req.getParameter("user_name");
		String email = req.getParameter("user_email");
		int travelLocation = Integer.parseInt(req.getParameter("user_travel_location"));

		newUser.setUser_name(fullName);
		newUser.setUser_email(email);
		newUser.setTravel_location(travelLocation);

		Patron_Service patron = new Patron_Service();
		try{
			patron.saveNewUser(newUser);
		}catch(Exception e) {
			System.out.println("Something went wrong inside user_servlet");
			e.printStackTrace();
		}
		
		
	}
}
