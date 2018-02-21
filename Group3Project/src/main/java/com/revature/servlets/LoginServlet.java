package com.revature.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		req.getRequestDispatcher("views/login.html").forward(req, res);
		
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session = req.getSession();
		System.out.println("in post");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if(password.equals("test") && username.equals("hello")){

			session.setAttribute("username", username);
 
			res.sendRedirect("views/main.html");
		} else {

			session.setAttribute("problem", "incorrect credentials");
			res.sendRedirect("views/login.html");
		}
		
		
	}

}
