package com.revature.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {
	
	public static String process(HttpServletRequest req) throws IOException {
		switch(req.getParameter("action")) {
		case "view-open-requests":
			return "../util/requests";
		case "login":
			return "login";
		default:
			return "error";
		}
	}

}
