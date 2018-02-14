package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = -756208604967516279L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// forward the request to Calculator.html page from "Calculator"
		RequestDispatcher rd = req.getRequestDispatcher("Calculator.html");
		rd.forward(req, res);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// obtain request parameters
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		String op = req.getParameter("operation");
		// System.out.println("n1:" + n1+ " n2: " + n1 + " operation" +op);
		String answer = "";
		try {
			float num1 = Float.parseFloat(n1);
			float num2 = Float.parseFloat(n2);
			switch (op) {
			case "add":
				answer = " " + (num1 + num2);
				break;
			case "subtract":
				answer = " " + (num1 - num2);
				break;
			case "multiply":
				answer = " " + (num1 * num2);
				break;
			case "divide":
				answer = " " + (num1 / num2);
				break;
			default:
				answer = "Invalid operation or number";
			}
		} catch (Exception e) {
			answer = "WOOPS!";
		}
		
		//Include answer in request
		req.setAttribute("answer", answer);
		
		//Forward request to answer servlet
		RequestDispatcher rd =req.getRequestDispatcher("answer");
		rd.forward(req, res);

	}

}
