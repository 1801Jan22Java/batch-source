package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.*;
import com.revature.dao.*;


public class EmployeeLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/employeelogin.html").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// set the correct content type
		response.setContentType("text/html");
		// from the form that was submitted
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// call the check credentials function to make sure the employees credentials
		// are a part of the database
		EmployeeDao ed = new EmployeeDaoSQL();
		Employee resultEmployee = ed.getEmployeeByCredentials(username, password);

		if (resultEmployee != null) {
			// set the session attributes so the username will be remembered
			session.setAttribute("username", username);
			session.setAttribute("id", resultEmployee.getEmployeeId());
			session.setAttribute("problem", null);
			request.getRequestDispatcher("employeehomepage").forward(request,response);
		} else {
			session.setAttribute("problem", "incorrect credentials");
			response.sendRedirect("employeelogin");
		}

	}

}
