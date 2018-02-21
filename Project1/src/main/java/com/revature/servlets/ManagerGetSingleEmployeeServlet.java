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

/**
 * Servlet implementation class ManagerGetSingleEmployeeServlet
 */
public class ManagerGetSingleEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			request.getRequestDispatcher("views/ManagerGetSingleEmployee.html?" + request.getQueryString()).forward(request, response);
		} else {
			response.sendRedirect("managerlogin");
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println("in post");
		if (session != null && session.getAttribute("username") != null) {
			
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
				JSONlist += "{\"remId\" : \"" + r.getReimbursementId() + "\"," ;
				JSONlist +=  "\"manId\" : \"" + r.getManagerId() + "\"," ;
				JSONlist += "\"status\" : \"" + sd.getStatusById(r.getStatus())  + "\"," ;
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
