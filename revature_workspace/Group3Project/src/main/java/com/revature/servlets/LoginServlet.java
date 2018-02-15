package com.revature.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		req.getRequestDispatcher("Login.html").forward(req, res);
		
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session = req.getSession();
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if(password.equals("test")){
			//pw.println("welcome, "+username);
			//pw.println("<a href=\"Index.html\">Go back</a>");
			session.setAttribute("username", username);
		//	session.setAttribute("problem", null);
			//doesn't exist YET. 
			res.sendRedirect("main.html");
		} else {
			//pw.println("nope");
			//pw.println("<a href=\"Index.html\">Go back</a>");
			session.setAttribute("problem", "incorrect password");
			res.sendRedirect("login");
		}
		
		
	}

}
