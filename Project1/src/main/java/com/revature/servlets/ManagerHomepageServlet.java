package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ManagerHomepageServlet
 */
public class ManagerHomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// if a get request is called make sure the user is a valid manager. if the user is not a valid manager, then redirect the
	// manager to the manager login. if the user is a valid manager, forward the user to the requested html page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if( session != null && session.getAttribute("username") != null && session.getAttribute("type") == "manager"){
			request.getRequestDispatcher("views/ManagerHomepage.html").include(request, response);
		} else {
			response.sendRedirect("managerlogin");
		}
	}

	// if a post is called, respond with get behavior
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
