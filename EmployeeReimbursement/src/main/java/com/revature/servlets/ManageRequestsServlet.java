package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ManageRequestsServlet
 */
public class ManageRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session.getAttribute("isManager") == "false") {
			RequestDispatcher rd = req.getRequestDispatcher("error");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("ManageRequests.html");
			rd.forward(req, resp);	
		}
		
	}

}
