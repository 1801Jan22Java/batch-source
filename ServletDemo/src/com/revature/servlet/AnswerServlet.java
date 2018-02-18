package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3000822135251686361L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// display answer with PrintWriter
		String answer = (String) req.getAttribute("answr");
		PrintWriter pw = resp.getWriter();
		pw.write("<p style = \"margin:30px\"> The answer is: " + answer + "</p>");
		pw.write("<p style = \"margin:30px\"><a href=\"calculator\">MORE NUMS PLEASE</a></p>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// view attributes of request
		Enumeration<String> atts = req.getAttributeNames();
		while (atts.hasMoreElements()) {
			String s = atts.nextElement();
			System.out.println(s + " " + req.getAttribute(s));
		}
				
		// display answer with PrintWriter
		String answer = (String) req.getAttribute("answer");
		PrintWriter pw = resp.getWriter();
		pw.write("<p style = \"margin:30px\"> The answer is: " + answer + "</p>");
		pw.write("<p style = \"margin:30px\"><a href=\"calculator\">MORE NUMS PLEASE</a></p>");
		
	}
}
