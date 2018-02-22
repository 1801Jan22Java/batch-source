package com.revature.servlets;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.*;
import com.revature.dao.*;

/**
 * Servlet implementation class ManagerGetReimbursementServlet
 */
public class ManagerGetReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// if a get request is called, make sure the user is a valid manager. if the user is not a valid manager then redirect the
	// user to the manager login. if the user is a valid manager, then obtain the information pertaining to the reimbursement
	// using the query string from the URL. depending on the status, a predicate (lambda function) is created to either check
	// for status codes above zero or equal to zero. the information is then gathered from the daos and packaged in JSON format
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "manager") {
			ReimbursementDao rd = new ReimbursementDaoSQL();
			EmployeeDao ed = new EmployeeDaoSQL();
			StatusDao sd = new StatusDaoSQL();
			EmployeeInformationDao eid = new EmployeeInformationDaoSQL();
			List<Reimbursement> re = rd.getReimbursement();
			String status = request.getQueryString().split("=")[1];
			Predicate<Integer> checkStatus = i -> {return i > 0;};
			switch (status) {
				case "resolved":
					checkStatus = i -> { return i > 0;};
					break;
				case "pending":
					checkStatus = i -> { return i == 0;};
					break;
			}
			String JSONlist = "[";
			int count = 0;
			for(Reimbursement r : re) {
				
				if(checkStatus.test(r.getStatus())) {
					if (count > 0){
						JSONlist += ",";
					}
					int employeeId = r.getEmployeeId();
					Employee requestedEmployee = ed.getEmployeeByID(employeeId);
					EmployeeInformation requestedEmployeeInformation = eid.getEmployeeInformationByID(employeeId);
					JSONlist += "{\"remId\" : \"" + r.getReimbursementId()  + "\",";
					JSONlist += "\"fname\" : \"" + requestedEmployeeInformation.getFname() + "\"," ;
					JSONlist += "\"lname\" : \"" + requestedEmployeeInformation.getLname() + "\"," ;
					JSONlist += "\"empId\" : \"" + requestedEmployee.getEmployeeId() + "\"," ;
					JSONlist += "\"status\" : \"" + sd.getStatusById(r.getStatus())  + "\"," ;
					JSONlist += "\"reimbursementVal\" : \"" + r.getReimbursementValue() + "\"}";
					count += 1;
				}
			}
			JSONlist += "]";
			response.getWriter().write(JSONlist);

		}
		else {
			response.sendRedirect("managerlogin");
		}
	}

	// if a post is called, call the get method to respond with get behavior.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
