package com.revature.servlet;

import java.io.IOException; 
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDaoImpl;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 817105812389880890L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/login.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		ArrayList<Employee> employees = edi.getAllEmployees();
		for(Employee e: employees) {
			if(e.getEmail().equals(username)) {
				if(e.getPassword().equals(password)) {
					session.setAttribute("username", e.getEmail());
					session.setAttribute("password", e.getPassword());
					session.setAttribute("is_manager", e.isManager());
					session.setAttribute("employeeID", e.getEmployeeID());
				}
				else {
					session.setAttribute("problem", "invalid credentials");
					resp.sendRedirect("login.html");
				}
			}
		}
	}

}
