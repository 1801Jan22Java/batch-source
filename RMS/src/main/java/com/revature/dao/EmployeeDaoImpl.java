package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.revature.beans.Employee;

import com.revature.exceptions.InvalidLoginException;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public int[] login(String username, String password) throws Exception {
		String sql = "SELECT EmployeeID, IsManager FROM Employee WHERE UserName = ? AND Password = ?";
		PreparedStatement pstmt = ConnectionUtil.getConnection().prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		// if successful returns EmployeeID and IsManager
		if (rs.next()) {
			int[] result = {rs.getInt("EmployeeID"), rs.getInt("IsManager")};
			return result;
		} else { // if unsuccessful throws InvalidLoginException
			throw new InvalidLoginException();
		}
	}

	@Override
	public ArrayList<Employee> viewInfo(int empID, int isManager) throws Exception {
		String sql;
		PreparedStatement pstmt;
		Connection conn = ConnectionUtil.getConnection();
		ArrayList<Employee> list = new ArrayList<Employee>();
		if(isManager == 0) {
			sql = "SELECT * FROM Employee WHERE EmployeeID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empID);
		} else {
			sql = "SELECT * FROM Employee";
			pstmt = conn.prepareStatement(sql);
		}
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Employee emp = new Employee(rs.getInt("EmployeeID"), rs.getString("Username"), rs.getString("Password"), rs.getString("FName"),
					rs.getString("LName"), rs.getString("Email"), rs.getInt("IsManager"));
			list.add(emp);
		}
		return list;
	}

	@Override
	public void updateInfo(Employee emp) throws Exception {
		String sql = "UPDATE Employee SET Username = ?, Password = ?, FName = ?, LName = ?, Email = ? WHERE EmployeeID = ?";
		PreparedStatement pstmt = ConnectionUtil.getConnection().prepareStatement(sql);
		pstmt.setString(1, emp.getUsername());
		pstmt.setString(2, emp.getPassword());
		pstmt.setString(3, emp.getfName());
		pstmt.setString(4, emp.getlName());
		pstmt.setString(5, emp.getEmail());
		pstmt.setInt(6, emp.getEmployeeID());
		pstmt.executeUpdate();
	}
}
