package com.ravature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet{

	private static final long serialVersionUID = -3690831856816505463L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//forward the request to our calculator.html page from "calculator"
		RequestDispatcher rd = req.getRequestDispatcher("Calculator.html");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//obtain request parameters
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		String operation = req.getParameter("operation");
		String answer = "";
		
		//calculate answer
		try {
			Double first = Double.parseDouble(n1);
			Double second = Double.parseDouble(n2);
			switch(operation) {
			case "add":
				answer = " "+(first+second);
				break;
			case "substract":
				answer = " "+(first-second);
				break;
			case "multiply":
				answer = " "+(first*second);
				break;
			case "divide":
				answer = " "+(first/second);
				break;
			default:
				answer = "Invalid number or operation";
				break;
					
			}
		}catch (Exception e) {
			answer = "Invalid number or operation";
		}
		
		//include answer in request
		req.setAttribute("answer", answer);
		
		//forward request to answer servlet
		RequestDispatcher rd = req.getRequestDispatcher("answer");
		rd.forward(req, resp);
		
		
		//display answer with PrintWriter
//		PrintWriter pw = resp.getWriter();
//		pw.write("<p style =\"margin:30px\"> The answer is: " + answer + "</p>");
//		pw.write("<p style =\"margin:30px\"><a href=\"calculator\">More Numbers Please</p>");
		
	}
	
}
