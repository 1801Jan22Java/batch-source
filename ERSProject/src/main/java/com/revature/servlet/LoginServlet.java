package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 5998678913965369616L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("home.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Post");
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		EmployeeDao dao = new EmployeeDaoImpl();
		Employee emp = dao.login(email, password);
		
		if(emp != null) {
			session.setAttribute("username", email);
			session.setAttribute("manager", emp.isManager());
			pw.println("Welcome, " + email);
			pw.println("<a href=home.html> Home <a>");
			resp.sendRedirect("EmployeeDashboard.html");
		}
		else {
			resp.sendRedirect("home.html");
			session.setAttribute("problem", "wrong password");
		}
	}
}
