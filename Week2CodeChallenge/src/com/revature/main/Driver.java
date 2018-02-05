package com.revature.main;

import com.revature.dao.DepartmentDaoImpl;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DepartmentDaoImpl dept = new DepartmentDaoImpl();
		System.out.println(dept.getDepartments());
	}

}
