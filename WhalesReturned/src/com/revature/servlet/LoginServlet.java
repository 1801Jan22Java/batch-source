package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 5998678913965369616L;
	
	public LoginServlet() {
		System.out.println("Here");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Post");
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println("Pass: " + password);
		if(password.equals("whales")) {
			session.setAttribute("username", email);
			pw.println("Welcome, " + email);
			pw.println("<a href=home.html> Home <a>");
			resp.sendRedirect("login");
		}
		else {
			pw.println("Nope, Go away");
			session.setAttribute("problem", "wrong password");
		}
	}
}
