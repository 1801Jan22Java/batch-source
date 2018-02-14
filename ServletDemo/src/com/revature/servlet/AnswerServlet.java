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
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		String answer = (String)req.getAttribute("answer");
		
		// display answer with PrintWriter
		PrintWriter pw = res.getWriter();
		pw.write("<p style=\"margin: 30px\">The answer is: "+answer+"</p>");
		pw.write("<p style=\"margin: 30px\"><a href=\"calculator\">return</a></p>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		// view the attributes of request, java object
		// we get :
		// javax.servlet.forward.request_uri
		// javax.servlet.forward.context_path
		// javax.servlet.forward.servlet_path
		// answer
		// Enumeration<String> atts = req.getAttributeNames();
		// while(atts.hasMoreElements()) {
		// System.out.println(atts.nextElement());
		// }
		
		
		Enumeration<String> atts = req.getAttributeNames();
		while(atts.hasMoreElements()) {
			String s = atts.nextElement();
			System.out.println(s + " : " + req.getAttribute(s));
		}
		// We get:
		// javax.servlet.forward.request_uri : /ServletDemo/calculator
		// javax.servlet.forward.context_path : /ServletDemo
		// javax.servlet.forward.servlet_path : /calculator
		// answer : 1.0
		
		// Get answer  value from request
		String answer = (String)req.getAttribute("answer");
		
		// display answer with PrintWriter
		PrintWriter pw = res.getWriter();
		pw.write("<p style=\"margin: 30px\">The answer is: "+answer+"</p>");
		pw.write("<p style=\"margin: 30px\"><a href=\"calculator\">return</a></p>");
	}
}
