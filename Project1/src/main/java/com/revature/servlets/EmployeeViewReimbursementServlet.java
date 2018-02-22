package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoSQL;
import com.revature.dao.StatusDao;
import com.revature.dao.StatusDaoSQL;

/**
 * Servlet implementation class EmployeeViewReimbursementServlet
 */
public class EmployeeViewReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	// when a get request is sent to this servlet it will check if the user is a valid employee, and if so it will
	// forward the request to the html page. the forwarded request will contain a queryString that was passed to the servlet
	// containing the employee's id to query for the reimbursement information if the user is not a valid employee, then send 
	// the user to the employee login page.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println(request.getQueryString().split("=")[1]);
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "employee") {
			request.getRequestDispatcher("views/EmployeeViewReimbursement.html?" + request.getQueryString().split("=")[1]).forward(request, response);
		}
		else {
			response.sendRedirect("employeelogin");
		}		
	}

	// if a post request is sent to this servlet, it will make sure the user is a valid employee before sending the information
	// queried. the servlet sends JSON formated information pertaining to a particular reimbursement that is specified by the query
	// string within the URL
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "employee") {
			
			ReimbursementDao rd = new ReimbursementDaoSQL();
			StatusDao sd = new StatusDaoSQL();
			response.setContentType("application/json");
			System.out.println(request.getQueryString());
			int id = Integer.parseInt(request.getQueryString().split("=")[1]);
			Reimbursement requestedReimbursement = rd.getReimbursementByID(id);
			
			// if the requestedReimbursement is null, something went wrong when querying the database, so
			// ignore the query
			if (requestedReimbursement != null) {
				String JSONobj = "";
	
				JSONobj += "{\"status\" : \"" + sd.getStatusById(requestedReimbursement.getStatus())+ "\"," ;
				if(requestedReimbursement.getManagerId() == 0) {
					JSONobj +=  "\"manId\" : \" N/A\"," ;
				}
				else {
					JSONobj +=  "\"manId\" : \" " + requestedReimbursement.getManagerId() + "\"," ;
				}
				JSONobj +=  "\"value\" : \"" + requestedReimbursement.getReimbursementValue() + "\"," ;
				JSONobj +=  "\"remId\" : \"" + requestedReimbursement.getReimbursementId() + "\"}" ;
				response.getWriter().write(JSONobj);
				System.out.println(JSONobj);
	
			}
		}
	}

}
