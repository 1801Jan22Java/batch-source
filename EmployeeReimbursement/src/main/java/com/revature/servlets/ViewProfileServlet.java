package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.Employee;
import com.revature.dao.EmployeeDaoImpl;

/**
 * Servlet implementation class ViewProfileServlet
 */
public class ViewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get this employee's information
		HttpSession session = req.getSession(false);
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		Employee currentEmployee = edi.readEmployee("MickeyMouse@magic.com");
		//Employee currentEmployee = edi.readEmployee(session.getAttribute("email").toString());
		
		//Parse the information into JSON format
		Gson gson = new Gson();
		String parsedEmployee = gson.toJson(currentEmployee);
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("ISO-8859-1");
		resp.getWriter().write(parsedEmployee);
	}



	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
