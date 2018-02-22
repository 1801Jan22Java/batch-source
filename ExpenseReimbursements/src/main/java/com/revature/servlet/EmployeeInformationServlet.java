package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeInformationServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("currentUser") != null) {
			String uri = req.getPathInfo().substring(1);
			resp.sendRedirect("/ExpenseReimbursements/employeeInformationPage/"+uri);
		} else {
			resp.sendRedirect("/ExpenseReimbursements/login");
		}
	}
	
}
