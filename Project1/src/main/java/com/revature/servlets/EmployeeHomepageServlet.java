package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeHomepageServlet
 */
public class EmployeeHomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if( session != null && session.getAttribute("username") != null){
			System.out.println(session.getAttribute("username"));
			req.getRequestDispatcher("views/employeehomepage.html").include(req, resp);
		} else {
			System.out.println("redirect");
			resp.sendRedirect("employeelogin");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
