package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.BearDao;
import com.revature.dao.BearDaoImpl;
import com.revature.dao.CaveDao;
import com.revature.dao.CaveDaoImpl;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		/*
		Connection con = null;
		
		try {
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			System.out.println(con.getMetaData().getDriverName());
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		// EmployeeDao cd = new EmployeeDaoImpl();
		// System.out.println(cd.getEmployees().toString());
		BearDao bear = new BearDaoImpl();
		bear.buildABear(8, "Beary", 5, 800, "06-NOV-12");
	}

}
