package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeServlet extends HttpServlet{

	private static final long serialVersionUID = -7142841198914007107L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Empserv get");
		HttpSession session = req.getSession();
		if(session != null && session.getAttribute("username") != null) {
			req.getRequestDispatcher("EmployeeDashboard.html");
		}
		else {
			resp.sendRedirect("home.html");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
