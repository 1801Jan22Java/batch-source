package com.revature.servlets;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.beans.EmployeeInformation;
import com.revature.beans.Reimbursement;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoSQL;
import com.revature.dao.EmployeeInformationDao;
import com.revature.dao.EmployeeInformationDaoSQL;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoSQL;
import com.revature.dao.StatusDao;
import com.revature.dao.StatusDaoSQL;


public class EmployeeGetReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// if a get request is called check if the user is a valid employee. if the user is not a valid employee, redirect
	// the user back  to the employee login page. if the user is a valid employee, return reimbursement informaiton 
	// from the dao based upon the parameter passed in the queryString stored in the URL. based on what is passed,
	// a predicate (lambda function) is used to decide which values to check for (equivalent to zero or greater than zero)
	// and returns the information in JSON format
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		// ensure a valid employee is only allowed to access this page
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "employee") {
			ReimbursementDao rd = new ReimbursementDaoSQL();
			EmployeeDao ed = new EmployeeDaoSQL();
			StatusDao sd = new StatusDaoSQL();
			EmployeeInformationDao eid = new EmployeeInformationDaoSQL();
			
			// get the id of the employee querying the reimbursements and show only those that are under his/her EmployeeId
			int id = (int)session.getAttribute("id");
			List<Reimbursement> listReimbursement= rd.getReimbursementByEmployeeId(id);
			String status = request.getQueryString().split("=")[1];
			// define a predicate to show either resolved or pending reimbursement statuses
			Predicate<Integer> checkStatus = i -> {return i > 0;};
			switch (status) {
				case "resolved":
					checkStatus = i -> { return i > 0;};
					break;
				case "pending":
					checkStatus = i -> { return i == 0;};
					break;
			}
			// set the content type and build a JSON Object that returns the first name, last name,
			// employeeid, status, and reimbursement value for the queried type of reimbursements
			response.setContentType("application/json");
			String JSONlist = "[";
			int count = 0;
			for(Reimbursement r : listReimbursement) {
				
				// depending on the queried status, the resulting reimbursements will change
				if(checkStatus.test(r.getStatus())) {
					if (count > 0) {
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
			System.out.println(JSONlist);
			response.getWriter().write(JSONlist);

		}
		// if the user is not a valid employee then redirect the user to the employee login page
		else {
			response.sendRedirect("employeelogin");
		}
	}

	// if a post request is called, then send a response for a get request instead
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
