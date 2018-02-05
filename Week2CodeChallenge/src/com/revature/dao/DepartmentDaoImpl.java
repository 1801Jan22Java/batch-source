package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.beans.Department;
import com.revature.util.ConnectionUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	public static final String filename = "connection.properties";
	
	@Override
	public void giveRaise(Department d) {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void getSalaries(Department d) {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
