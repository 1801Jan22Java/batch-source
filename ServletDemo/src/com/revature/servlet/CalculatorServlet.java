package com.revature.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = -756208604967516279L;
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// forward the request to our Calculator.html page from "calculator"
		RequestDispatcher rd = req.getRequestDispatcher("Calculator.html");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// obtain request parameters
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		String operation = req.getParameter("operation");
		String answer = "";
//		System.out.println(n1);
//		System.out.println(n2);
//		System.out.println(operation);
		
		// calculate answer
		try {
			Double first = Double.parseDouble(n1);
			Double second = Double.parseDouble(n2);
			switch(operation) {
			case "add": 
				answer = " " + (first + second);
				break;
			case "subtract": 
				answer = " " + (first - second);
				break;
			case "multiply": 
				answer = " " + (first * second);
				break;
			case "divide": 
				answer = " " + (first / second);
				break;
			default:
				answer = "invalid number or operation";
			}
		} catch (Exception e) {
			answer = "invalid number or operation";
		}
		
		// include answer in request
		req.setAttribute("answer", answer);
		
		// forward request to AnswerServlet
		RequestDispatcher rd = req.getRequestDispatcher("answer");
		rd.forward(req, resp);
		
		// display answer with PrintWriter
//		PrintWriter pw = resp.getWriter();
//		pw.write("<p style= \"margin: 30px\"> The answer is: " + answer + "</p>");
//		pw.write("<p style= \"margin: 30px\"><a href=\"calculator\">MORE NUMBERS PLEASE</a></p>");
		
	} // end doPost()

}
