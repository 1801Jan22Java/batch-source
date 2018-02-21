package com.revature.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		boolean manager = (boolean)session.getAttribute("is_manager");
		if(manager) {
			req.getRequestDispatcher("manager_info");
			resp.setContentType("application/json");
			PrintWriter pw = resp.getWriter();
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
			ArrayList<Employee> drones = edi.getAllEmployees();
			ArrayList<String> employeeInfo;
			for(Employee john: drones) {
				employeeInfo = john.getTableValues();
				pw.write("<tr>");
				for(String s: employeeInfo) {
					pw.write("<td>"+s+"</td>");
				}
				pw.write("</tr>");
			}
		} else {
			req.getRequestDispatcher("employee_info");
			resp.setContentType("application/json");
			PrintWriter pw = resp.getWriter();
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
			Employee john = edi.getEmployeeById((int) session.getAttribute("employeeID"));
			ArrayList<String> employeeInfo = john.getTableValues();
			pw.write("<tr>");
			for(String s: employeeInfo) {
				pw.write("<td>"+s+"</td>");
			}
			pw.write("</tr>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		boolean manager = (boolean)session.getAttribute("is_manager");
		if(manager) {
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
			int eid = (int) req.getAttribute("Emp_id");
			Employee emp = edi.getEmployeeById(eid);
			String firstname = (String) req.getAttribute("firstName");
			String lastname = (String) req.getAttribute("lastName");
			String email = (String) req.getAttribute("email");
			String phone = (String) req.getAttribute("phone");
			String jobTitle = (String) req.getAttribute("jobTitle");
			edi.updateEmployee(new Employee(eid, firstname, lastname, 
					email, emp.getPassword(), emp.getReportsTo(), phone, jobTitle, false, 1));
			
		} else {
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
			Employee emp = edi.getEmployeeById((int)session.getAttribute("employeeID"));
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
