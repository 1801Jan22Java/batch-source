package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ManagerGetResolved
 */
public class ManagerGetResolvedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// if a get request is called make sure the user is a valid manager. if the user is not a valid manager, then redirect the
	// manager to the manager login. if the user is a valid manager, forward the user to the requested html page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if( session != null && session.getAttribute("username") != null && session.getAttribute("type") == "manager"){
			request.getRequestDispatcher("views/ManagerGetResolved.html").forward(request, response);
		} 
		else {
			response.sendRedirect("managerlogin");
		}
	}

	// if a post is called call get to create a response.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
