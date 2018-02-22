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

public class UpdateInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3402941689741785285L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		boolean manager = ((String) session.getAttribute("is_manager") == "true");
		if (manager) {

			PrintWriter pw = resp.getWriter();
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
			ArrayList<Employee> drones = edi.getAllEmployees();
			ObjectMapper om = new ObjectMapper();
			String jsonValue = om.writeValueAsString(drones);
			pw.write(jsonValue);
		} else {
			PrintWriter pw = resp.getWriter();
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
			Employee john = edi.getEmployeeById((Integer) session.getAttribute("employeeID"));
			ObjectMapper om = new ObjectMapper();
			String jsonValue = om.writeValueAsString(john);
			resp.setContentType("application/json");
			pw.write(jsonValue);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		boolean manager = ((String) session.getAttribute("is_manager") == "true");
		// general idea - pre-fill local variables with values from extant employee object
		// go through form fields, replace the local variables with non-null form field values
		// set the employee's fields to the local variables. 
		// That way, user doesn't have to update every field 
		if (manager) {
			// if user is a manager -> update the employee with the given ID
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
			int eid = Integer.parseInt(req.getParameter("Emp_id"));
			Employee emp = edi.getEmployeeById(eid);

			String firstname = emp.getFirstName();
			System.out.println(firstname + " Before temp");
			String temp = req.getParameter("firstName");
			if (temp != "") {
				firstname = req.getParameter("firstName");
				System.out.println(firstname + " After temp");
			}

			String lastname = emp.getLastName();
			temp = req.getParameter("lastName");
			if (temp != "") {
				lastname = req.getParameter("lastName");

			}

			String email = emp.getEmail();
			temp = req.getParameter("email");
			if (temp != "")  {
				email = req.getParameter("email");
			}

			String phone = emp.getPhone();
			temp = req.getParameter("phone");
			if (temp != "")  {
				phone = req.getParameter("phone");
			}

			String jobTitle = emp.getJobTitle();
			temp = req.getParameter("jobTitle");
			if (temp != "")  {
				jobTitle = req.getParameter("jobTitle");
			}
			
			emp.setFirstName(firstname);
			emp.setLastName(lastname);
			emp.setEmail(email);
			emp.setPhone(phone);
			emp.setJobTitle(jobTitle);
			
			edi.updateEmployee(emp);
			resp.sendRedirect("./manager_home");

		} else {
			// if user is not a manager, update the currently logged in user
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
			int eid = Integer.parseInt(req.getParameter("Emp_id"));
			Employee emp = edi.getEmployeeById(eid);

			String firstname = emp.getFirstName();
			String temp = req.getParameter("firstName");
			if (temp != "")  {
				firstname = req.getParameter("firstName");
			}

			String lastname = emp.getLastName();
			temp = req.getParameter("lastName");
			if (temp != "")  {
				lastname = req.getParameter("lastName");

			}

			String email = emp.getEmail();
			temp = req.getParameter("email");
			if (temp != "")  {
				email = req.getParameter("email");
			}

			String phone = emp.getPhone();
			temp = req.getParameter("phone");
			if (temp != "")  {
				phone = req.getParameter("phone");
			}

			String jobTitle = emp.getJobTitle();
			temp = req.getParameter("jobTitle");
			if (temp != "")  {
				jobTitle = req.getParameter("jobTitle");
			}

			emp.setFirstName(firstname);
			emp.setLastName(lastname);
			emp.setEmail(email);
			emp.setPhone(phone);
			emp.setJobTitle(jobTitle);
			edi.updateEmployee(emp);
			resp.sendRedirect("./employee_home");
		}
	}

}
