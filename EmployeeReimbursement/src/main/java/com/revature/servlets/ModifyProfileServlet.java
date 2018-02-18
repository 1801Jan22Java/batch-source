package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;

/**
 * Servlet implementation class ModifyProfileServlet
 */
public class ModifyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String shortened = req.getRequestURI();
		shortened = shortened.substring(shortened.indexOf("modifyprofile/")+14);
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		HttpSession session = req.getSession(false);
		int id = Integer.valueOf(session.getAttribute("id").toString());
		if(req.getParameter("modifyFirstName") != "") {
			session.setAttribute("firstName", req.getParameter("modifyFirstName"));
			edi.updateEmployeeFirstName(id, req.getParameter("modifyFirstName"));
		}
		if(req.getParameter("modifyLastName") != "") {
			session.setAttribute("lastName", req.getParameter("modifyLastName"));
			edi.updateEmployeeLastName(id, req.getParameter("modifyLastName"));
		}
		if(req.getParameter("modifyEmail") != "") {
			session.setAttribute("email", req.getParameter("modifyEmail"));
			edi.updateEmployeeEmail(id, req.getParameter("modifyEmail"));
		}
			
		
		RequestDispatcher rd = req.getRequestDispatcher("ProfileChangesSaved.html");
		rd.forward(req, resp);
	}

}
