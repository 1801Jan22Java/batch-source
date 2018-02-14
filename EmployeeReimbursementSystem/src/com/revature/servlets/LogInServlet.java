package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.*;
import com.revature.dao.*;

public class LogInServlet extends HttpServlet {
	
	private static final long serialVersionUID = 3955358416341714606L;

/*	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Obtain login information
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
	}*/
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Obtain login information
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		
		System.out.println(email);
		System.out.println(password);
		
		
	}
}
