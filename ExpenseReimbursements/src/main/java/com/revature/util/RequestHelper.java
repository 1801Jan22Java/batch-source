package com.revature.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {
	
	public static String managerProcess(HttpServletRequest req) throws IOException{
		switch(req.getParameter("destination")) {
		case "allEmployees":
			return "allEmployees";
		case "viewAllPendingRequests":
			return "viewAllPendingRequests";
		case "viewAllResolvedRequests":
			return "viewAllResolvedRequests";
		case "submitRequest":
			return "submitRequest";
		case "viewEmpPendingRequests":
			return "viewEmpPendingRequests";
		case "viewEmpResolvedRequests":
			return "viewEmpResolvedRequests";
		case "viewEmpInfo":
			return "viewEmpInfo";
		default:
			return "error";
		}
	}
	
	public static String employeeProcess(HttpServletRequest req) throws IOException{
		switch(req.getParameter("destination")) {
		case "submitRequest":
			return "submitRequest";
		case "viewEmpPendingRequests":
			return "viewEmpPendingRequests";
		case "viewEmpResolvedRequests":
			return "viewEmpResolvedRequests";
		case "viewEmpInfo":
			return "viewEmpInfo";
		default: 
			return "error";
		}
	}
}
