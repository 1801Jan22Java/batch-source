package com.ravature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerServlet extends HttpServlet {

	private static final long serialVersionUID = -9152634889167938867L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String answer = (String) req.getAttribute("answer");
		PrintWriter pw = resp.getWriter();
		pw.write("<p style =\"margin:30px\"> The answer is: " + answer + "</p>");
		pw.write("<p style =\"margin:30px\"><a href=\"calculator\">More Numbers Please</p>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//view attributes of request
		Enumeration<String> atts = req.getAttributeNames();
		
		while (atts.hasMoreElements()) {
			String s = atts.nextElement();
			System.out.println(s + " : " + req.getAttribute(s));
		}
		
		
		//Display answer in PrintWriter
		String answer = (String) req.getAttribute("answer");
		PrintWriter pw = resp.getWriter();
		pw.write("<p style =\"margin:30px\"> The answer is: " + answer + "</p>");
		pw.write("<p style =\"margin:30px\"><a href=\"calculator\">More Numbers Please</p>");
	}

}
