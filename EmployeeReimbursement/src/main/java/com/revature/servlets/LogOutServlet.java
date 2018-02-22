package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Invalidates the current session and forwards the user to the Logout page.
 */

public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);	//Defaults to false
		
		
		if(session != null) {
			//Note: this does NOT delete JSESSIONID. It DOES log you out, however.
			session.invalidate();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("LogOut.html");
		rd.forward(req, resp);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
