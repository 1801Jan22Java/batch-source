package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeLogoutServlet
 */
public class EmployeeLogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		req.setAttribute("destination", "employeelogout");
		req.getRequestDispatcher("views/index.html").include(req,resp);
		HttpSession session = req.getSession(false);
		if(session != null){
			System.out.println("session is not null so it is invalid");
			session.invalidate();
		}
		else {
			System.out.println("SESSION IS NULL SO WTF");
			resp.sendRedirect("views/index.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
