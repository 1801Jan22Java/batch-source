package com.revature.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Department;
import com.revature.beans.Employee;
import com.revature.dao.DepartmentDao;
import com.revature.dao.DepartmentDaoImpl;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.util.ConnectionUtil;

public class Main {

	public static void main(String[] args) {
		try {
			ConnectionUtil.connectToDatabase("Connection.Properties");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		
		DepartmentDao depDao = new DepartmentDaoImpl();
		List<Department> departments = depDao.getDepartments();
		System.out.println();
		
		EmployeeDao empDao = new EmployeeDaoImpl();
		List<Employee> employees = empDao.getEmployees();
		listEmployees(employees);
		
		depDao.giveRaise(1001);
		
		employees = empDao.getEmployees();
		listEmployees(employees);
		
		System.out.println("Department average: " + getDepartmentAvgSal(1001, employees));
		
		ConnectionUtil.disconnect();
	}

	private static void listEmployees(List<Employee> emps) {
		for(Employee emp : emps) {
			System.out.println(emp.getFirstName() + " " + emp.getLastName() + " " + emp.getDep_id() +  " " + emp.getSalary());
		}
	}
	
	private static void listDepartments() {
		
	}
	
	private static int getDepartmentAvgSal(int depID, List<Employee> emps) {
		
		int count = 0;
		int sal = 0;
		
		for(Employee emp : emps) {
			if(emp.getDep_id() == depID) {
				count++;
				sal += emp.getSalary();
			}
		}
		
		return count > 0 ? sal / count : 0;
	}
	
	//private static String depIdToString(int id, List<Department> deps) {
		//for(Department dep : deps) {
		//	return
		//}
	//}
}
