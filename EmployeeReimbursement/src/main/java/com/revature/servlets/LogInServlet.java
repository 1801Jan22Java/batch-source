package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.*;
import com.revature.dao.*;

public class LogInServlet extends HttpServlet {
	
	private static final long serialVersionUID = 3955358416341714606L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("LogIn.html").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		resp.setContentType("text/html");
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		
		HttpSession session = req.getSession(true);
		
		if(password.equals("admin123")) {
			//pw.println("Welcome, "+username);
			//pw.println("<a href=\"Index.html\">Go back</a>");

			
			//Set appropriate attributes to user's info
			session.setAttribute("email", email);
			session.setAttribute("problem", null);
			
			//Doesn't exist yet
			resp.sendRedirect("Index.html");	//Redirect to Profile.html if successful login.
		} else {
			//pw.println("nope");
			//pw.println("<a href=\"Index.html\">Go back</a>");
			session.setAttribute("problem", "Incorrect password");
			resp.sendRedirect("login");
		}
	}
}
