package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.beans.RequestLog;
import com.revature.util.ConnectionUtil;

public class RequestLogDaoImpl implements RequestLogDao {

	@Override
	public boolean createRequestLog(int requestID, String response, int managerID, int statusID, double dispensed) {
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			
			pstmt = conn.prepareStatement("INSERT INTO REQUEST_LOG "
					+ "(REQUEST_ID,RESPONSE,MANAGER_ID,STATUS_ID,DISPENSED)"
					+ " VALUES (?,?,?,?,?);");
			pstmt.setInt(1, requestID);
			pstmt.setString(2, response);
			pstmt.setInt(3, managerID);	//1 - NOT SUBMITTED
			pstmt.setInt(4, statusID);
			pstmt.setDouble(5, dispensed);
			pstmt.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public RequestLog readRequestLog(int requestID) {
		// TODO Auto-generated method stub
		return null;
	}

}
