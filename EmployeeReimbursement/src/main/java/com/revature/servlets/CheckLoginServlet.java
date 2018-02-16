package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		//Find correct password here
		if(password.equals("admin123")) {
			//pw.println("Welcome, "+username);
			//pw.println("<a href=\"Index.html\">Go back</a>");

			
			//Set appropriate attributes to user's info
			session.setAttribute("email", email);
			session.setAttribute("problem", null);
			
			
			resp.sendRedirect("Index.html");
		} else {
			//pw.println("nope");
			//pw.println("<a href=\"Index.html\">Go back</a>");
			session.setAttribute("problem", "Incorrect password");
			resp.sendRedirect("login");
		}
	}

}
