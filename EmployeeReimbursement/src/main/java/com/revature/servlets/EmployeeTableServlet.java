package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.CompletedRequest;
import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.RequestDaoImpl;

/**
 * Servlet implementation class EmployeeTableServlet
 */
public class EmployeeTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		
		List<Employee> employees = edi.readAllEmployees();
		
		//Parse the information into JSON format
		Gson gson = new Gson();
		String parsedLogs = gson.toJson(employees);
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("ISO-8859-1");
//		System.out.println(parsedLogs);
		resp.getWriter().write(parsedLogs); 
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
