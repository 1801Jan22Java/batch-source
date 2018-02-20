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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			ReimbursementDao rd = new ReimbursementDaoSQL();
			EmployeeDao ed = new EmployeeDaoSQL();
			StatusDao sd = new StatusDaoSQL();
			EmployeeInformationDao eid = new EmployeeInformationDaoSQL();
			int id = (int)session.getAttribute("id");
			List<Reimbursement> listReimbursement= rd.getReimbursementByEmployeeId(id);
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
			int i = 0;
			for(Reimbursement r : listReimbursement) {
				i += 1;
				if(checkStatus.test(r.getStatus())) {
					int employeeId = r.getEmployeeId();
					Employee requestedEmployee = ed.getEmployeeByID(employeeId);
					EmployeeInformation requestedEmployeeInformation = eid.getEmployeeInformationByID(employeeId);
					JSONlist += "{\"fname\" : \"" + requestedEmployeeInformation.getFname() + "\"," ;
					JSONlist += "\"lname\" : \"" + requestedEmployeeInformation.getLname() + "\"," ;
					JSONlist += "\"empId\" : \"" + requestedEmployee.getEmployeeId() + "\"," ;
					JSONlist += "\"status\" : \"" + sd.getStatusById(r.getStatus())  + "\"," ;
					JSONlist += "\"reimbursementVal\" : \"" + r.getReimbursementValue() + "\"}";
					if (i < listReimbursement.size()) {
						JSONlist += ",";
					}
				}
			}
			JSONlist += "]";
			response.getWriter().write(JSONlist);

		}
		else {
			response.sendRedirect("employeelogin");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
