package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RespectBinding;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("Login.html").forward(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		PrintWriter pw = res.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		res.setContentType("text/html");
		if (password.equals("asdf")) {
			// pw.println("welcome: " + username);
			// pw.println("<a href=\"Index.html\"> Go back</a>");
			session.setAttribute("username", username);
			session.setAttribute("problem", null);
			
			res.sendRedirect("profile");
		} else {
			// pw.println("nope");
			session.setAttribute("problem", "wrong password");
		}
		req.getRequestDispatcher("Login.html").forward(req, res);
	}
}
