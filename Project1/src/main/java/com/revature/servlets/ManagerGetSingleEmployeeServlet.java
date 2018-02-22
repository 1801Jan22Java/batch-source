package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.*;
import com.revature.dao.*;
/**
 * Servlet implementation class ManagerGetSingleEmployeeServlet
 */
public class ManagerGetSingleEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	// if a get request is called make sure the user is a valid manager. if the user is not a valid manager, then redirect the
	// manager to the manager login. if the user is a valid manager, forward the user to the requested html page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "manager") {
			request.getRequestDispatcher("views/ManagerGetSingleEmployee.html?" + request.getQueryString()).forward(request, response);
		} else {
			response.sendRedirect("managerlogin");
		}	
	}

	// if a get request is called make sure the user is a valid manager. if the user is not a valid manager, then redirect the
	// manager to the manager login. if the user is a valid manager, obtain information from the query string to find 
	// information on the single employee from the daos. the information is the packaged in JSON format.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println("in post");
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "manager") {
			
			response.setContentType("application/json");
			int id = Integer.parseInt(request.getQueryString().split("=")[1]);
			ReimbursementDao rd = new ReimbursementDaoSQL();
			StatusDao sd = new StatusDaoSQL();
			EmployeeInformationDao eid = new EmployeeInformationDaoSQL();
			List<Reimbursement> listReimbursement= rd.getReimbursementByEmployeeId(id);
			EmployeeInformation requestedEmployeeInformation = eid.getEmployeeInformationByID(id);
			String JSONlist = "";
			if (requestedEmployeeInformation != null) {
				
				JSONlist += "{\"fname\" : \"" + requestedEmployeeInformation.getFname() + "\"," ;
				JSONlist +=  "\"lname\" : \"" + requestedEmployeeInformation.getLname() + "\"," ;
				JSONlist +=  "\"email\" : \"" + requestedEmployeeInformation.getEmail() + "\"," ;
				JSONlist +=  "\"address\" : \"" + requestedEmployeeInformation.getAddress()  + "\"," ;
				JSONlist +=  "\"id\" : \"" + requestedEmployeeInformation.getEmployeeInformationId() + "\"," ;

			}
			
			JSONlist += "\"arr\":[";
			int i = 0;
			for(Reimbursement r : listReimbursement) {
				i += 1;
				int status = r.getStatus();
				JSONlist += "{\"remId\" : \"" + r.getReimbursementId() + "\"," ;
				JSONlist +=  "\"manId\" : \"" + r.getManagerId() + "\"," ;
				JSONlist += "\"status\" : \"" + sd.getStatusById(status)  + "\"," ;
				JSONlist += "\"reimbursementVal\" : \"" + r.getReimbursementValue() + "\"}";
				if (i < listReimbursement.size()) {
					JSONlist += ",";
				}
				
			}
			JSONlist += "]}";
			response.getWriter().write(JSONlist);
			System.out.println(JSONlist);
		}
		else {
			response.sendRedirect("managerlogin");
		}
	}

}
