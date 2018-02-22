package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDaoPLSQLImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Forward any get to the html file that contains the login page
		RequestDispatcher view = request.getRequestDispatcher("views/Login.html");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAO ed = new EmployeeDaoPLSQLImpl();
		StringBuffer b = new StringBuffer();
		String line = null;
		ObjectMapper map = new ObjectMapper();
		BufferedReader rdr = request.getReader();
		//Parse the body of the post request
		while ((line = rdr.readLine()) != null) {
			b.append(line);
		}
		JsonNode j = map.readTree(b.toString());
		
		//Send the user name and password to the dao to sign in
		Employee empl = ed.signIn(j.get("username").textValue(), j.get("password").textValue());
		
		//see if the employee successfully logged in
		if (empl != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("emplId", empl.getId());
			response.sendRedirect("employee");	
		}
	}
	
}
