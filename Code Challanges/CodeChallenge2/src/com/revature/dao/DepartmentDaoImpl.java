package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.revature.beans.Department;
import com.revature.util.ConnectionUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	public static final String filename = "connection.properties";
	
	@Override
	public void giveRaise(Department d) {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "{CALL SP_GIVE_RAISE(?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, d.getDepartmentID());
			cs.executeUpdate();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Integer> getSalaries(Department d) {
		ArrayList<Integer> salaries = new ArrayList<Integer>();
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			int did = d.getDepartmentID();
			Integer sal = 0;
			String sql = "SELECT SALARY, DEPARTMENT_ID FROM EMPLOYEE WHERE DEPARTMENT_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, d.getDepartmentID());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				did = rs.getInt(1);
				sal = rs.getInt(2);
				salaries.add(sal);
				
			}
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return salaries;

	}

}
