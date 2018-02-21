package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ManagerHomeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("currentUser") != null) {
			req.getRequestDispatcher("views/managerHome.html").forward(req, resp);
		} else {
			resp.sendRedirect("/ExpenseReimbursements/login");
		}
	}
}
