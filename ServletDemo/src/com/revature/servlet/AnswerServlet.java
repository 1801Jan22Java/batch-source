package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerServlet extends HttpServlet {

	private static final long serialVersionUID = 3557676882839440662L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Need to acquire parameter from CalculatorServlet, (attribute is dynamically set)
		String answer = (String) req.getAttribute("answer");	//getAttribute returns an object, so we cast it to String
		
		//Display answer with PrintWriter
		PrintWriter pw = resp.getWriter();
		pw.write("<p style = \"margin:30px\"> The answer is: " + answer + "</p>");
		pw.write("<p style = \"margin:30px\"><a href=\"calculator\">MORE NUMBERS PLEASE</p>");
	}
	
	
	//CalculatorServlet was handling a POST request, so we need to override doPost here too.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//View the attributes of our request
		Enumeration<String> atts = req.getAttributeNames();
		
		//Boolean loop condition
		while(atts.hasMoreElements()) {
			String s = atts.nextElement();
			System.out.println(s + " : " + req.getAttribute(s));
		}
		
		//Need to acquire parameter from CalculatorServlet, (attribute is dynamically set)
		String answer = (String) req.getAttribute("answer");	//getAttribute returns an object, so we cast it to String
		
		//Display answer with PrintWriter
		PrintWriter pw = resp.getWriter();
		pw.write("<p style = \"margin:30px\"> The answer is: " + answer + "</p>");
		pw.write("<p style = \"margin:30px\"><a href=\"calculator\">MORE NUMBERS PLEASE</p>");
	}
	
}
