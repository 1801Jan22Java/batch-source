package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerServlet extends HttpServlet {

	private static final long serialVersionUID = 3557676882839440662L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// display answer with PrintWriter
		String answer = (String) req.getAttribute("answer");
		PrintWriter pw = resp.getWriter();
		pw.write("<p style = \"margin:30px\"> The answer is: " + answer + "</p>");
		pw.write("<p style = \"margin:30px\"><a href=\"calculator\">MORE NUMBERS PLEASE</a></p>");

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// display answer with PrintWriter
		String answer = (String) req.getAttribute("answer");
		PrintWriter pw = resp.getWriter();
		pw.write("<p style = \"margin:30px\"> The answer is: " + answer + "</p>");
		pw.write("<p style = \"margin:30px\"><a href=\"calculator\">MORE NUMBERS PLEASE</a></p>");

	}

}
