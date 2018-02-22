package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.getRequestDispatcher("index.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if(password.equals("password")) {
//			pw.println("welcome, " + username);
//			pw.println("<a href=\"Index.html\">Go back </a>");
			session.setAttribute("username", username);
			session.setAttribute("problem", null);
			// doesn't exist YET
			resp.sendRedirect("genres");
		} else {
//			pw.println("nope");
//			pw.println("<a href=\"Index.html\">Go back </a>");
			session.setAttribute("problem", "incorrect password");
			resp.sendRedirect("login");
		}
	}
}
