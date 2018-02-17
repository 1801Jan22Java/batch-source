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

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("employee get???");
		req.getRequestDispatcher("views/employeelogin.html").forward(req,resp);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		// set the correct content type
		resp.setContentType("text/html");
		// from the form that was submitted
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// call the check credentials function to make sure the employees credentials
		// are a part of the database
		if (checkCredentials(username,password)) {
			System.out.println("correct user");
			// set the session attributes so the username will be remembered
			session.setAttribute("username", username);
			session.setAttribute("problem", null);
			req.getRequestDispatcher("employeehomepage").forward(req,resp);
		} else {
			session.setAttribute("problem", "incorrect credentials");
			resp.sendRedirect("employeelogin");
		}
		
	}
	
	private boolean checkCredentials(String username, String password) {
		EmployeeDao ed = new EmployeeDaoSQL();
		Employee resultEmployee = ed.getEmployeeByCredentials(username, password);
		if (resultEmployee != null) {
			return true;
		}
		return false;
	}

}
