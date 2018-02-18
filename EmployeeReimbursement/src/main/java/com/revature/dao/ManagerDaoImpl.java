package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Request;
import com.revature.util.ConnectionUtil;


public class ManagerDaoImpl implements ManagerDao {

	@Override
	public boolean isManager(int employeeID) {
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = conn.prepareStatement("SELECT * FROM MANAGER WHERE EMPLOYEE_ID=?");
			pstmt.setInt(1,employeeID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
			//Email does not exist
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return false;
	}
	
	public int getManagerID(int employeeID) {
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = conn.prepareStatement("SELECT * FROM MANAGER WHERE EMPLOYEE_ID=?");
			pstmt.setInt(1,employeeID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("MANAGER_ID");
			}
			
			//Email does not exist
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return -1;
	}
	
	public String getManagerName(int managerID) {
		String managerName = "";
		int employeeID;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = conn.prepareStatement("SELECT * FROM MANAGER WHERE MANAGER_ID=?");
			pstmt.setInt(1, managerID);
			rs = pstmt.executeQuery();
			
			Request currReq = null;
			if(rs.next()) {
				employeeID = rs.getInt("EMPLOYEE_ID");
				
				pstmt = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID=?");
				pstmt.setInt(1, employeeID);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					managerName = rs.getString("FIRST_NAME") + " " + rs.getString("LAST_NAME");
				}
				
				return managerName;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return managerName;
	}
}
