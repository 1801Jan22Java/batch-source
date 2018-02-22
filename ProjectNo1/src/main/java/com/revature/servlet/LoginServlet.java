package com.revature.servlet;

import java.io.IOException; 
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
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
		String username ="";
		String password = "";
		if(req.getParameter("email") != null && req.getParameter("password") != null) {
			username = req.getParameter("email");
			password = req.getParameter("password");
		}
		else {
			
		}
		EmployeeDao edi = new EmployeeDaoImpl();
		HttpSession session = req.getSession();
		
		ArrayList<Employee> employees = edi.getAllEmployees();
		
		for(Employee e: employees) {
			System.out.println(e.toString());
		}
		
		for(Employee e: employees) {
			if(e.getEmail().equals(username)) {
				if(e.getPassword().equals(password)) {
					session.setAttribute("username", e.getEmail());
					session.setAttribute("password", e.getPassword());
					if(e.isManager())
						session.setAttribute("is_manager", "true");
					else
						session.setAttribute("is_manager", "false");
					session.setAttribute("employeeID", e.getEmployeeID());
					if(e.isManager())
						resp.sendRedirect("./manager_home");
					else
						resp.sendRedirect("./employee_home");
				}
				else {
					session.setAttribute("problem", "invalid credentials");
					resp.sendRedirect("./login.html");
				}
			}
		}
	}

}
