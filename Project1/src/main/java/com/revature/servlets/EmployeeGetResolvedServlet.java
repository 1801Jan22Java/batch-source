package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeGetResolvedServlet
 */
public class EmployeeGetResolvedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	// if a get request is called, then make sure a valid employee is logged in to view the page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if( session != null && session.getAttribute("username") != null && session.getAttribute("type") == "employee"){
			request.getRequestDispatcher("views/EmployeeGetResolved.html").forward(request, response);
		} 
		else {
			response.sendRedirect("employeelogin");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
