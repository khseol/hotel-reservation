package com.skillstorn.reservation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author Kathy
 * This is the servlet that will try and handle the request from the default page
 * ie. this class will redirect the reservation process to the initial jsp page for
 * the reservation process.
 * 
 * this servlet is mapped to /hello
 */
@WebServlet(name = "hello", urlPatterns = "/hello")
public class Hello_Servlet extends HttpServlet {

	/**
	 * POST request from the HTTP that will take the button in my index, and redirect to the /hello servlet page.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String helloUser = req.getParameter("start-reservation");
		System.out.println("Starting the reservation process"); //to see where the information is being handled.
		req.getSession().setAttribute("helloUser", helloUser);
		req.getRequestDispatcher("/jsp_pages/user-information.jsp").forward(req, resp); //this is dumb
		
	}
	
}
