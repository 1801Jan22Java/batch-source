package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.DepartmentOracle;
import com.revature.dao.EmployeeOracle;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		DepartmentOracle dep = new DepartmentOracle();
		EmployeeOracle eo = new EmployeeOracle();
		
		dep.printAvgSalary();
		eo.giveRaise(1);
		dep.printAvgSalary();
	}

}
