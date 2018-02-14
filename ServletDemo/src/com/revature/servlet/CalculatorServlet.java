package com.revature.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = -756208604967516279L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Forward the request to our Calculator.html page from "calculator"
		// Calculator.html is at the top level of our WebContent folder.
		RequestDispatcher rd = req.getRequestDispatcher("Calculator.html");
		rd.forward(req, resp);
		// As of yet, we haven't mapped it yet.
		// Register servlet in the web.xml file
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// We want to obtain the request parameters
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		String operation = req.getParameter("operation");
		String answer = "";

		// Calculate answer
		try {
			Double first = Double.parseDouble(n1);
			Double second = Double.parseDouble(n2);
			switch (operation) {
			case "add":
				answer = " " + (first + second); // Type coercion by adding the " " in front
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
				answer = "Invalid number or operation."; // You can throw an exception too.
			}

		} catch (Exception e) {
			answer = "Invalid number or operation.";
		}

		// Now, we include the answer in our request (packet of information)
		req.setAttribute("answer", answer); // We alter the REQUEST, and we'll use it in our RESPONSE.

		// CalculatorServlet has done its job, so now we forward the answer to AnswerServlet
		// The parameter of getRequestDispatcher points to the <url-pattern> element in
		// web.xml to forward to a particular server.
		// CalculatorServlet -> RequestDispatcher("answer") -> web.xml <url-pattern>
		// /answer -> AnswerServlet.java -> the doPost(), where the request and response
		// from CalculatorServlet is put in the parameter
		RequestDispatcher rd = req.getRequestDispatcher("answer");
		rd.forward(req, resp);
	}
}
