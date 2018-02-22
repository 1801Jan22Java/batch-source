package com.revature.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {
	public static String process(HttpServletRequest request) throws IOException
	{
		System.out.println("You passed through the RequestHelper");
		switch(request.getParameter("destination"))
		{
		case "home":
			return "home";
		case "login":
			return "initializeTable";
		case "logout":
			return "logout";
		case "initializeTable":
			return "initializeTable";
		case "LoginServlet":
			return "LoginServlet";
		case "MasterServlet":
			return "MasterServlet";
		case "EmployeeServlet":
			return "EmployeeServlet";
		case "RequestServlet":
			return "RequestServlet";
		case "ErrorServlet":
			return "ErrorServlet";
		default:
			return "error";
		}
	}
}
