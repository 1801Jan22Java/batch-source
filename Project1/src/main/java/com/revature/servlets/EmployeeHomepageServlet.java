package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeHomepageServlet
 */
public class EmployeeHomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// if a get request is called on this servlet, check the users credentials through the session
	// if the user is not an employee with a valid username, then send the user back to the login page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		// mainly for session management to ensure the correct users access the correct pages
		if( session != null && session.getAttribute("username") != null && session.getAttribute("type") == "employee"){
			request.getRequestDispatcher("views/EmployeeHomePage.html").include(request, response);
		} else {
			response.sendRedirect("employeelogin");
		}
	}

	// if a post is called on this servlet then call a get instead.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
