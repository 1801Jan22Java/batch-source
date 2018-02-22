package com.revature.servlet;


import java.io.IOException; 
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.util.RequestHelper;

public class UpdateInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3402941689741785285L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		boolean manager = ((String)session.getAttribute("is_manager")=="true");
		if(manager) {
			
			PrintWriter pw = resp.getWriter();
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
			ArrayList<Employee> drones = edi.getAllEmployees();
			ObjectMapper om = new ObjectMapper();
			String jsonValue = om.writeValueAsString(drones);
			pw.write(jsonValue);
		} else {
			PrintWriter pw = resp.getWriter();
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
			System.out.println(session.getAttribute("employeeID"));
			Employee john = edi.getEmployeeById((Integer)session.getAttribute("employeeID"));
			ObjectMapper om = new ObjectMapper();
			String jsonValue = om.writeValueAsString(john);
			resp.setContentType("application/json");
			pw.write(jsonValue);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		boolean manager = ((String)session.getAttribute("is_manager")=="true");
		if(manager) {
			// if user is a manager -> update the employee with the given ID
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
			int eid = (Integer) req.getAttribute("Emp_id");
			Employee emp = edi.getEmployeeById(eid);
			String firstname = (String) req.getAttribute("firstName");
			String lastname = (String) req.getAttribute("lastName");
			String email = (String) req.getAttribute("email");
			String phone = (String) req.getAttribute("phone");
			String jobTitle = (String) req.getAttribute("jobTitle");
			edi.updateEmployee(new Employee(eid, firstname, lastname, 
					email, emp.getPassword(), emp.getReportsTo(), phone, jobTitle, false, 1));
			
		} else {
			// if user is not a manager, update the currently logged in user
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
			Employee emp = edi.getEmployeeById((Integer)session.getAttribute("employeeID"));
			String firstname = (String) req.getAttribute("firstName");
			String lastname = (String) req.getAttribute("lastName");
			String email = (String) req.getAttribute("email");
			String phone = (String) req.getAttribute("phone");
			String jobTitle = (String) req.getAttribute("jobTitle");
			
			edi.updateEmployee(new Employee(emp.getEmployeeID(), firstname, lastname, 
					email, emp.getPassword(), emp.getReportsTo(), phone, jobTitle, false, 1));
		}
	}

}
