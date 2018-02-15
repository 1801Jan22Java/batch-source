package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		PrintWriter pw = resp.getWriter();		//We get our writer from the response
		
		resp.setContentType("text/html");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(password.equals("asdfasdfasdf")) {
			//pw.println("Welcome, "+username);
			//pw.println("<a href=\"Index.html\">Go back</a>");
			session.setAttribute("username", username);
			session.setAttribute("problem", null);
			
			//Doesn't exist yet
			resp.sendRedirect("index.html");	//Redirect to Profile.html if successful login.
		} else {
			//pw.println("nope");
			//pw.println("<a href=\"Index.html\">Go back</a>");
			session.setAttribute("problem", "Incorrect password");
			resp.sendRedirect("index.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
