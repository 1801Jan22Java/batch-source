package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeLogoutServlet
 */
public class EmployeeLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// log the user out of the system by invalidating the session that carried his/her data
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/Logout.html").include(request,response);
		HttpSession session = request.getSession(false);
		// if the session is not null, then invalidate the session available
		if(session != null){
			session.invalidate();
		}

	}

	// if a post request is called, then send a get response instead
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
