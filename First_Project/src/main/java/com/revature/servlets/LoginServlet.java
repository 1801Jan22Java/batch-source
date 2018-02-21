package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.main.Waiter;
import com.revature.util.ConnectionUtil;


public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Login.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		try {
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			}catch(Exception e) {
				e.printStackTrace();
			}
		HttpSession session = req.getSession(true);
		Waiter help = new Waiter();
		EmployeeDaoImpl emp = new EmployeeDaoImpl();
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String username = req.getParameter("username").toString();
		String password = req.getParameter("password").toString();

		
		if(help.getAuth(username, password)){
			System.out.println("manager status " +emp.is_Manager(username, password));
			if(emp.is_Manager(username, password)) {
				session.setAttribute("username", username);
				session.setAttribute("Employee_Id",emp.getEmployee_ID());
				session.setAttribute("problem", null);
				resp.sendRedirect("ManagerHome.html");
				
			}else {
			System.out.println(emp.getEmployee_ID());
			session.setAttribute("username", username);
			session.setAttribute("Employee_Id",emp.getEmployee_ID());
			session.setAttribute("problem", null);
			resp.sendRedirect("EmployeeHome.html");
		}
		} else {

			session.setAttribute("problem", "incorrect password");
			resp.sendRedirect("login");
		}
	}

}
