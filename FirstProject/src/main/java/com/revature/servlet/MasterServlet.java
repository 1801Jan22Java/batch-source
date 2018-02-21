package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MasterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7137510907868382469L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// note - login page doesn't have an option for logging in as manager;
		// if credentials match a manager, they get the manager homepage
		// if credentials match an employee, they get the employee homepage 
		// if credentials don't match anything, they get redirected back to login
		HttpSession session = req.getSession();
		boolean manager = (Boolean) session.getAttribute("is_manager");
		if(manager) {
			req.getRequestDispatcher("manager_home").forward(req, resp);
		} else {
			req.getRequestDispatcher("employee_home").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		boolean manager = (Boolean)session.getAttribute("is_manager");
		if(manager) {
			
		} else {
			
		}
	}

	

}
