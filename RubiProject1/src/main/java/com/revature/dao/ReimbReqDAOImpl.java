package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class ReimbReqDAOImpl implements ReimbReqDAO {

	@Override
	public int addNewReimbReq(int employeeId, String reqStatus, String receipt) {
		int reimbReqCreated = 0;
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "INSERT INTO ReimbReq (EmployeeId, ReqStatus, Receipt) VALUES (?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setInt(1, bear.getBearType().getId());
			pstmt.setString(2, bear.getName());
			pstmt.setDate(3, Date.valueOf(bear.getBirthdate()));
			
			reimbReqCreated = pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return reimbReqCreated;
	}

}
