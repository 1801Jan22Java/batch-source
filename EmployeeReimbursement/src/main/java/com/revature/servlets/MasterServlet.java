package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.util.RequestHelper;

/**
 * Servlet implementation class MasterServlet
 */
public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("Index.html");
		rd.forward(req, resp);
	}


	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Process the request, taking in the "destination" parameter from the front-end
		// and returning the string corresponding to the alias of the appropriate
		// servlet.
		String destination = RequestHelper.process(req);

		
		RequestDispatcher rd = req.getRequestDispatcher("/"+destination);
		rd.forward(req, resp);
	}

}
