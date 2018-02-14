package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Provide calculator page
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Forward the request to our Calculator.html page from "calculator"
		RequestDispatcher rd = req.getRequestDispatcher("Calculator.html");
		rd.forward(req, res);
	}

	// Calculate and post data?
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Obtain request params
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		String operation = req.getParameter("operation");
		String answer = "";

		// System.out.println(n1);
		// System.out.println(n2);
		// System.out.println(operation);

		// calculate answer
		try {
			Double first = Double.parseDouble(n1);
			Double second = Double.parseDouble(n2);
			switch (operation) {
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
				answer = "inalid number or operation";
				break;
			}
		} catch (Exception e) {
			answer = "invalid number or operation";
		}

		// include the answer in the response
		// We'll be using this request and forward it to another servlet
		// Could also do with PrintWriter
		 req.setAttribute("answer", answer);
		 
		 // Forward request to AnswerServlet
		 // Servlet url-pattern goes into getRequestDispatcher param
		 // to forward to a particular server.
		 // In this case:
		 // CalculatorServlet -> Request Dispatcher ("answer") -> web.xml url-pattern /answer 
		 // -> AnswerServlet.java -> the doPost(), where the request and response from CalculatorServlet is put in the params
		 RequestDispatcher rd = req.getRequestDispatcher("answer");
		 rd.forward(req, res);
		
		// // display answer with PrintWriter
		// // moved to AnswerServlet
		// PrintWriter pw = res.getWriter();
		// pw.write("<p style=\"margin: 30px\">The answer is: "+answer+"</p>");
		// pw.write("<p style=\"margin: 30px\"><a href=\"calculator\">return</a></p>");
	}

}
