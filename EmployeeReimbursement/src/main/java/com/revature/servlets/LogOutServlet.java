package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		req.getRequestDispatcher("Base.html").include(req, resp);
		HttpSession session = req.getSession(false);	//Defaults to false
		
		
		if(session != null) {
			//Note: this does NOT delete JSESSIONID. It DOES log you out, however.
			session.invalidate();
		}
		pw.println("You are successfully logged out!");
		pw.println("<a href=\"LogIn.html\">Go back</a>");
		pw.write("</body></html>");
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
