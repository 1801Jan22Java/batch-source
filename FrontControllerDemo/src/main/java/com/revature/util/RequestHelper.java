package com.revature.util;

import java.io.IOException;
import javax.servlet.http.*;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

public class RequestHelper {

	public static String process(HttpServletRequest req) throws IOException{
		switch(req.getParameter("destination")) {
		case "bears":
				return "bear";
		case "caves":
				return "caves";
		default:
				return "error";
		}
	}

}
