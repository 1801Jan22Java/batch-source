package com.revature.main;

import com.revature.dao.DepartmentDAO;
import com.revature.dao.DepartmentDAOImpl;

public class Driver {

	public static void main(String[] args) {

		DepartmentDAO department = new DepartmentDAOImpl();
		System.out.println(department.getAllDepartments());
	}

}
