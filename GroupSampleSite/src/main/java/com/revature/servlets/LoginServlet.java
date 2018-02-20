package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.html").forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		PrintWriter pw = resp.getWriter();		//We get our writer from the response

		resp.setContentType("text/html");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		if(password.equals("admin123")) {
			//pw.println("Welcome, "+username);
			//pw.println("<a href=\"Index.html\">Go back</a>");
			session.setAttribute("email", email);
			session.setAttribute("problem", null);
			
			//Doesn't exist yet
			resp.sendRedirect("index");	//Redirect to Profile.html if successful login.
		} else {
			//pw.println("nope");
			//pw.println("<a href=\"Index.html\">Go back</a>");
			session.setAttribute("problem", "Incorrect password");
			resp.sendRedirect("login.html");
		}
	}

}
