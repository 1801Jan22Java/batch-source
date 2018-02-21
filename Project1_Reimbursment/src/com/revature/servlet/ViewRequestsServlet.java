package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewRequestsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3622166310225164697L;

	public ViewRequestsServlet() {
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		boolean manager = (boolean) session.getAttribute("is_manager");
		if(manager) {
			req.getRequestDispatcher("manager_requests.html").forward(req, resp);
		} else {
			req.getRequestDispatcher("employee_requests.html").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Not supporting post, b/c this page & servlet is for info only 
		super.doPost(req, resp);
	}

}
