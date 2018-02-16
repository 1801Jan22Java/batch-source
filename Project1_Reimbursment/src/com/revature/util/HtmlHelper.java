package com.revature.util;

import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.dao.EmployeeDaoImpl;

public class HtmlHelper {

	public ArrayList<String> getFormattedEmployees(ArrayList<Employee> employees) {
		//To view employees, this method will take all employees
		// and return a String ArrayList containing formatted HTML strings
		// that can be directly inserted into the page table
		ArrayList<String> html = new ArrayList<String>();
		EmployeeDaoImpl EDI = new EmployeeDaoImpl();
		Employee emp;
		String temp = "";
		for(Employee e: employees) {
			temp = "<td>"+e.getFirstName()+"</td>"
				+ "<td>"+e.getLastName()+"</td>"
				+ "<td>"+e.getEmail()+"</td>"
				+"<td>"+e.getJobTitle()+"</td>"
				+"<td>"+EDI.getEmployeeById(e.getReportsTo()).getFirstName()
				+" "+EDI.getEmployeeById(e.getReportsTo()).getLastName()+"</td>";
			
			html.add(temp);
		}
		
		return html;
	}
	
	public ArrayList<String> getFormattedRequestsByEmployee(ArrayList<Request> requests){
		ArrayList<String> html = new ArrayList<String>();
		String temp = "";
		for(Request r: requests) {
			
			
		}
		
		return html;
	}

}
