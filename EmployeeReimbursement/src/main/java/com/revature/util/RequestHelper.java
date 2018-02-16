package com.revature.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {
	public static String process(HttpServletRequest req) throws IOException {
		String shortened = req.getRequestURI();
		shortened = shortened.substring(shortened.indexOf("admin/")+6);
		
		switch(shortened) {	//req.getAttribute("name");
			//req.getServletPath();
		
		//Direct to servlets via aliases
		case "checklogin":
			return "checklogin";
		case "/LogOut":
			return "logout";
		default:
			return "error";
		}
	}
	
	public static void printAThing(String str) {
		System.out.println(str);
	}
}