package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	

}
