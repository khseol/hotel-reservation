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
 * 
 * req.getContextPath()+ "/jsp_pages/userInformation.jsp" --> in the back of my head
 */
@WebServlet(name = "hello", urlPatterns = "/hello")
public class Hello_Servlet extends HttpServlet {

	/**
	 * POST request from the HTTP that will take the button in my index, and redirect to the /hello servlet page.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String helloUser = req.getParameter("start-reservation"); //the name of the input
		//System.out.println(helloUser); //the NAME of the input tag is passed and the VALUE of the same tag is output.
		resp.sendRedirect("userServlet"); //by redirecting the /hello userServlet, the userServlet is loaded.
	}
	
}
