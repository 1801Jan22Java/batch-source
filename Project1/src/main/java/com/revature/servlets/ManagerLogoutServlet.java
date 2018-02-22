package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ManagerLogoutServlet
 */
public class ManagerLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// a get request is just making sure there is a session that can be invalidated. if there is a session that is still
	// valid, then invalidate it and forward to logout html.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/Logout.html").include(request,response);
		HttpSession session = request.getSession(false);
		if(session != null){
			session.invalidate();
		}
	}

	// if post is called then call get to respond with get behavior
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
