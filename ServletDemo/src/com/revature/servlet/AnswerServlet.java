package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3000822135251686361L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String answer = (String)req.getAttribute("answer");
		//display answer with PrintWriter
		PrintWriter pw = resp.getWriter();
		pw.write("<p style= \"margin:30px\"> The answer is: " + answer + "</p>");
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String answer = (String)req.getAttribute("answer");
		Enumeration<String> atts = req.getAttributeNames();
		while(atts.hasMoreElements()) {
			System.out.println(atts.nextElement());
		}
		//display answer with PrintWriter
		PrintWriter pw = resp.getWriter();
		pw.write("<p style= \"margin:30px\"> The answer is: " + answer + "</p>");
		pw.write("<p style = \"margin:30px\"><a href=\"calculator\">MORE NUMBERS PLZ</a>");
	}

}
