
package com.revature.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {

	public static String process(HttpServletRequest req) throws IOException {
		switch (req.getParameter("destination")) {
		case "Employee home":
			return "employee_home";
		case "Employee info":
			return "employee_info";
		case "Employee Requests":
			return "employee_requests";
		case "Login":
			return "login";
		case "Manager Home":
			return "manager_home";
		case "Manager Info":
			return "manager_info";
		case "Manager Requests":
			return "manager_requests";
		case "Submit Request":
			return "new_request";
		case "Request events":
			return "request_events";
		case "Submit Manager Request":
			return "submit_manager_request";
		case "View employees":
			return "view_employees";
		
		default:
			return "error";
		}
	}

}