package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ManagerDaoImpl;
import com.revature.util.RequestHelper;

/**
 * Servlet implementation class CheckLoginServlet
 */
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String email = req.getParameter("email");
		String password = req.getParameter("pass");

		resp.setContentType("text/html");
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();

		//Find correct password here
		Employee toCheck = edi.readEmployee(email);
		if(password.equals(toCheck.getPassword())) {
			
			//Set appropriate attributes to user's info
			session.setAttribute("id", toCheck.getId());
			session.setAttribute("firstName", toCheck.getFirstName());
			session.setAttribute("lastName", toCheck.getLastName());
			session.setAttribute("email", email);
			session.setAttribute("problem", null);
			
			ManagerDaoImpl mdi = new ManagerDaoImpl();
			if(mdi.isManager(toCheck.getId())) {
				session.setAttribute("isManager", "true");
			} else {
				session.setAttribute("isManager", "false");
			}
			RequestDispatcher rd = req.getRequestDispatcher("CheckingLogin.html");
			rd.forward(req, resp);
			
		} else {
			session.setAttribute("problem", "Incorrect password");
			resp.sendRedirect("login");
		}
	}

}
