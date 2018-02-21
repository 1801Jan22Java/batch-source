package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewEmployeesServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3266326837660922082L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		boolean manager = (boolean)session.getAttribute("is_manager");
		if(manager) {
			req.getRequestDispatcher("manager_info");
		} else {
			req.getRequestDispatcher("employee_info");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		boolean manager = (boolean)session.getAttribute("is_manager");
		if(manager) {
			
		} else {
			
		}
	}

}
