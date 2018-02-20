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
 * Servlet implementation class ManagerGetEmployeeServlet
 */
public class ManagerGetEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			request.getRequestDispatcher("views/ManagerGetEmployee.html").forward(request, response);
		} else {
			response.sendRedirect("managerlogin");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			response.setContentType("application/json");
			EmployeeDao ed = new EmployeeDaoSQL();
			EmployeeInformationDao eid = new EmployeeInformationDaoSQL();
			List<Employee> listEmployee = ed.getEmployees();
			String JSONlist = "[";
			int i = 0;
			for(Employee emp : listEmployee) {
				i += 1;
				int employeeId = emp.getEmployeeId();
				EmployeeInformation requestedEmployeeInformation = eid.getEmployeeInformationByID(employeeId);
				JSONlist += "{\"fname\" : \"" + requestedEmployeeInformation.getFname() + "\"," ;
				JSONlist += "\"lname\" : \"" + requestedEmployeeInformation.getLname() + "\"," ;
				JSONlist += "\"empId\" : \"" + employeeId + "\"," ;
				JSONlist += "\"email\" : \"" + requestedEmployeeInformation.getEmail() + "\"," ;
				JSONlist += "\"address\" : \"" + requestedEmployeeInformation.getAddress() + "\"," ;
				JSONlist += "\"username\" : \"" + emp.getUsername() + "\",";
				JSONlist += "\"password\" : \"" + emp.getPassword() + "\"}";

				if (i < listEmployee.size()) {
					JSONlist += ",";
				}
			}
			JSONlist += "]";
			response.getWriter().write(JSONlist);

		}
		else {
			response.sendRedirect("managerlogin");
		}
	}

}
