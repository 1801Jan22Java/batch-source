package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * When a manager wishes to view all requests belonging to a single employee,
 * whether they're pending or completed.
 * 
 */
public class AllEmployeeRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		session.setAttribute("IDToView", req.getParameter("allemployeerequests"));
		
		RequestDispatcher rd = req.getRequestDispatcher("EmployeeRequests.html");
		rd.forward(req, resp);	
	}

}
