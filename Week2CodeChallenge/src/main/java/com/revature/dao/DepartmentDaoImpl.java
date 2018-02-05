package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.revature.beans.Department2;
import com.revature.beans.Employee2;
import com.revature.util.ConnectionUtil;

public class DepartmentDaoImpl implements DepartmentDao {
	private static String filename = "connection.properties";

	@Override
	public void nameAvgSalary(int id) {
		PreparedStatement pstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			int average = 0;
			String sql = "SELECT AVG(SALARY) FROM EMPLOYEE2 WHERE DEPARTMENT_ID=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				average = rs.getInt(1);
			}
			
			System.out.println("Old average for " + this.getDepartment2ById(id).getName() +" is " + average);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Department2 getDepartment2ById(int id) {
		PreparedStatement pstmt = null;
		Department2 dep = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM DEPARTMENT2 WHERE DEPARTMENT_ID=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String name = rs.getString("DEPARTMENT_NAME");
				dep = new Department2(id, name);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dep;
	}

	@Override
	public void giveRaise(int id) {
		CallableStatement cstmt = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			int average = 0;
			
			String sql = "{CALL SP_GIVE_RAISE(?, ?)}";
			cstmt = con.prepareCall(sql);
			
			cstmt.setInt(1, id);
			cstmt.registerOutParameter(2, Types.INTEGER);
			
			cstmt.execute();
			average = cstmt.getInt(2);
			
			System.out.println("New average is " + average);
			System.out.println();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
