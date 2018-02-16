package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Staff;
import com.revature.util.ConnectionUtil;

public class StaffDAOImpl implements StaffDAO {

	@Override
	public List<Staff> getAllStaff() {
		List<Staff> listStaff = new ArrayList<>();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM Staff";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int employeeId = rs.getInt("EmployeeId");
				String lastName = rs.getString("LastName");
				String firstName = rs.getString("FirstName");
				String email = rs.getString("Email");
				String password = rs.getString("Pass");
				String username = rs.getString("Username");
				int isManager = rs.getInt("IsManager");
				int reportsTo = rs.getShort("ReportsTo");
				listStaff.add(new Staff(employeeId, lastName, firstName, email, password, username, 
						isManager, reportsTo));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return listStaff;
	}

	@Override
	public Staff getStaff(String email) {
		Staff currStaff = null;
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT EmployeeId FROM Staff WHERE Email = ?";
			pstmt.setString(1, email);
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int employeeId = rs.getInt("EmployeeId");
				String lastName = rs.getString("LastName");
				String firstName = rs.getString("FirstName");
				String password = rs.getString("Pass");
				String username = rs.getString("Username");
				int isManager = rs.getInt("IsManager");
				int reportsTo = rs.getShort("ReportsTo");
				currStaff = new Staff(employeeId, lastName, firstName, email, password, username, isManager, reportsTo);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return currStaff;
	}

}
