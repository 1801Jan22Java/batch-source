package com.revature.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.RequestDaoImpl;

/**
 * Servlet implementation class SubmitRequestServlet
 */
public class SubmitRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}


	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		
		RequestDaoImpl rdi = new RequestDaoImpl();
		java.util.Date currDate = new java.util.Date();	//Get current time in milliseconds
		Date dateSubmitted = new Date(currDate.getTime());
		
		int id = Integer.valueOf(session.getAttribute("id").toString());
		String description = req.getParameter("description");
		Double amount = Double.valueOf(req.getParameter("amount"));
		
		boolean made = rdi.createRequest(id, dateSubmitted, description, amount);
		
		if(made) {
			req.getRequestDispatcher("submitpage").forward(req, resp);
		} else {
			req.getRequestDispatcher("submitrequest").forward(req, resp);
		}
	}

}
