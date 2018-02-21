package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SessionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// servlet is used mainly for the view/html pages. they call this to check if the id is null, if it is, then
	// the user has somehow gotten access to the page and will be redirected to the index page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			response.setContentType("application/json");
			response.getWriter().write("{\"id\":\"" + session.getAttribute("id") + "\"}");
			response.getWriter().write("{\"type\":\"" + session.getAttribute("type") + "\"}");
		} else {
			response.setContentType("application/json");
			response.getWriter().write("{\"id\":null}");
		}
	}
	
	// if a post is called on this servlet then call a get instead.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
