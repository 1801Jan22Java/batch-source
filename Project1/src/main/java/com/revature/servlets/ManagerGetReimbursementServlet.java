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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
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
			System.out.println(JSONlist);
			response.getWriter().write(JSONlist);

		}
		else {
			response.sendRedirect("managerlogin");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
