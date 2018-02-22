package com.revature.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.RequestHelper;

public class EmployeeActionServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("views/employeeHome.html");
		rd.forward(req, resp);
	}
	
	// From the Employee Home, the form submits a POST request which gets mapped to this servlet.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String employeeAction = RequestHelper.employeeProcess(req);
		resp.sendRedirect(employeeAction);
	}
}

