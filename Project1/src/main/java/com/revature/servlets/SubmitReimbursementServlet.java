package com.revature.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoSQL;

//TODO: double check and make sure the post request should be here

public class SubmitReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// if a get request is called, then ensure that a valid employee is getting access to the html page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "employee") {
			request.getRequestDispatcher("views/submitreimbursement.html").forward(request, response);
		}
		else {
			response.sendRedirect("employeelogin");
		}
		
	}

	// if a post request is called, then ensure that a valid employee is getting access to information that is about to be
	// sent. 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "employee") {
			
			// get the image from the request inputstream and write the information into a ByteArrayOutputStream
			ServletInputStream in = request.getInputStream();
			ByteArrayOutputStream bao = new ByteArrayOutputStream();
			String query = request.getQueryString();
			
			// pass the reimbursement value through the URL as a query string
			Double reimbursementValue = Double.parseDouble(query.split("=")[1]);
			ReimbursementDao rd = new ReimbursementDaoSQL();
			// ensure the inputstream even has information to load
			if (in.available() > 0) {
				int c = 0;
				while((c=in.read()) != -1) {
					bao.write(c);
				}
				// convert the ByteArrayOutputStream into a byte arr which is used to convert to a blob that is stored in the DB
				byte [] byteArr = bao.toByteArray();
				rd.submitReimbursement((int)session.getAttribute("id"), reimbursementValue,byteArr);
				
			}
			response.sendRedirect("submitreimbursement");
		}
		else {
			response.sendRedirect("employeelogin");
		}
	}

}
