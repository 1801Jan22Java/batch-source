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
		//Still need to map the ones below
		case "viewAllResolvedRequests":
			return "viewAllResolvedRequests";
		default:
			return "error";
		}
	}
}
