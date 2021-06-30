package com.skillstorn.reservation.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.reservation.models.Travel_Locations;
import com.skillstorm.reservation.models.User_Information;
import com.skillstorm.reservation.service.Patron_Service;
import com.skillstorm.reservation.service.Travel_Service;
/**
 * 
 * @author Kathy
 * BECAUSE THE JSP PAGES ARE IN FOLDERS(!!!!!!!!), THE mapping OF THE SERVLETS WILL NEED TO BE SPECIFIC IN LOACTION
 * ON WHERE THE METHODS ARE BEING INVOKED
 * 
 * /jsp_pages/userServlet --> the back of my head
 */

@WebServlet(name = "reservation-user", urlPatterns = "/userServlet") //in the action, only 'userServlet' is mapped to call the methods
public class UserServelet extends HttpServlet{

	Travel_Service tService = new Travel_Service();
	Patron_Service pService = new Patron_Service();
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User_Information newUser = new User_Information();
		String name = req.getParameter("user_name");
		String email = req.getParameter("user_email");
		int location_id = Integer.parseInt(req.getParameter("user_location"));
		
		System.out.println(name + ' ' + email +' ' +location_id); //test if information was successfully received.
		//once submitted, create the new user object and save it to database.
		newUser.setUser_name(name);
		newUser.setUser_email(email);
		newUser.setTravel_location(location_id);
		
		
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Travel_Locations> getAllLocations =tService.listAllLocations();
		//System.out.println(getAllLocations);
		req.getSession().setAttribute("locationData", getAllLocations);
		
		req.getRequestDispatcher("jsp_pages/userInformation.jsp").forward(req, resp);

	}
	
}
