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

/*
 * EmployeeId NUMBER NOT NULL,
 * LastName VARCHAR2(20) NOT NULL,
 * FirstName VARCHAR2(20) NOT NULL,
 * Email VARCHAR2(60) NOT NULL,
 * Pass VARCHAR2(20) NOT NULL,
 * Username VARCHAR2(20),
 * IsManager NUMBER,
 * ReportsTo NUMBER
 */

public class StaffDAOImpl implements StaffDAO {
	
	/*
	 * (non-Javadoc)
	 * @see com.revature.dao.StaffDAO#addNewStaff(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int)
	 * Adds new staff to Staff table, 'EmployeeId' not required because it's auto incremented via SQL.
	 * NOT REQUIRED: username, isManager, reportsTo
	 */
	@Override
	public int addNewStaff(String lastName, String firstName, String email, String password, String username,
			int isManager, int reportsTo) {
		int newStaffCreated = 0;
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "INSERT INTO Staff (LastName, FirstName, Email, Pass, Username, IsManager, " + 
					"ReportsTo) VALUES (?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lastName);
			pstmt.setString(2, firstName);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			pstmt.setString(5, username);
			pstmt.setInt(6, isManager);
			pstmt.setInt(7, reportsTo);
			newStaffCreated = pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newStaffCreated;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.revature.dao.StaffDAO#getAllStaff()
	 * Returns an ArrayList of the Staff table.
	 * int id, String lastName, String firstName, String email, String username, String strManager, int reportsTo
	 */
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
				String username = rs.getString("Username");
				int isManager = rs.getInt("IsManager");
				String strManager;
				if(isManager == 1) {
					strManager = "yes";
				} else {
					strManager = "no";
				}
				int reportsTo = rs.getShort("ReportsTo");
				listStaff.add(new Staff(employeeId, lastName, firstName, email, username, strManager, reportsTo));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return listStaff;
	}

	/*
	 * (non-Javadoc)
	 * @see com.revature.dao.StaffDAO#getStaff(java.lang.String)
	 * Returns a single row in Staff via email.
	 */
	@Override
	public Staff getStaff(String email) {
		Staff currStaff = null;
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM Staff WHERE Email = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
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
	
	/** Updates staff information given employeeId **/
	@Override
	public int updateInfo(String lastName, String firstName, String email, String password, String username, int employeeId) {
		int updatedStaff = 0;
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "UPDATE Staff SET LastName=?, FirstName=?, Email=?, Pass=?, Username=? WHERE EmployeeId = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lastName);
			pstmt.setString(2, firstName);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			pstmt.setString(5, username);
			pstmt.setInt(6, employeeId);
			updatedStaff = pstmt.executeUpdate();
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return updatedStaff;
	}
}
