package com.revature.main;

import com.revature.dao.DepartmentDaoImpl;
import com.revature.dao.EmployeeDaoImpl;

public class Driver {

	public static void main(String[] args) {
		DepartmentDaoImpl ddi = new DepartmentDaoImpl();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		
		edi.getEmployees();
		ddi.getAllDepartments();

		edi.giveRaise(1);
		
		edi.printDepartmentSalary();
	}

}
