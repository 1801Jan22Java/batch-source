package com.revature.project1.servlet;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AnswerServlet extends HttpServlet {

	private static final long serialVersionUID = -3000822135251686361L;
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//display answer with PrintWriter
		String answer =(String) req.getAttribute("answer");
		PrintWriter prw = res.getWriter();
		prw.write("<p style= \"margin:30px\"> The answer is: "+ answer+"</p>");
		prw.write("<p style = \"margin:30px\"><a href=\"approvalpage.html\">Do more calculations</a></p>");
	}

	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		//view attributes of request
		Enumeration<String> atts = req.getAttributeNames();
		
		while(atts.hasMoreElements()) {
			String s= atts.nextElement();
		//	System.out.println(s+ "\t:\t"+req.getAttribute(s));
			
		}
		//display answer with PrintWriter
		String answer =(String) req.getAttribute("answer");
		PrintWriter prw = res.getWriter();
		prw.write("<p style= \"margin:30px\"> The answer is: "+ answer+"</p>");
		prw.write("<p style = \"margin:30px\"><a href=\"approvalpage.html\">Do more calculations</a></p>");
	}
}
