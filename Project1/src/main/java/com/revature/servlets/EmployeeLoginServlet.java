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

	private static final long serialVersionUID = 1L;

	// if a get request is called on this servlet, forward the request to the login page!
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/EmployeeLogin.html").forward(request,response);
	}

	// if a post request is called, take information and check the users credentials
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

		// if the resulting employee is null, then the credentials do not exist within the DB so redirect them back to the login page
		if (resultEmployee != null) {
			// set the session attributes so the username will be remembered
			session.setAttribute("username", username);
			session.setAttribute("type", "employee");
			session.setAttribute("id", resultEmployee.getEmployeeId());
			session.setAttribute("problem", null);
			response.sendRedirect("employeehomepage");
		} else {
			session.setAttribute("problem", "incorrect credentials");
			response.sendRedirect("employeelogin");
		}

	}

}
