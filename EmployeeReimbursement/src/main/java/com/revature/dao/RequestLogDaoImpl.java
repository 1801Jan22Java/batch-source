package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Request;
import com.revature.beans.RequestLog;
import com.revature.util.ConnectionUtil;

public class RequestLogDaoImpl implements RequestLogDao {

	@Override
	public boolean createRequestLog(int requestID, String response, int managerID, int statusID, double dispensed) {
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			
			pstmt = conn.prepareStatement("INSERT INTO REQUEST_LOG "
					+ "(REQUEST_ID,RESPONSE,MANAGER_ID,STATUS_ID,DISPENSED)"
					+ " VALUES (?,?,?,?,?)");
			pstmt.setInt(1, requestID);
			pstmt.setString(2, response);
			pstmt.setInt(3, managerID);	//1 - NOT SUBMITTED
			pstmt.setInt(4, statusID);
			pstmt.setDouble(5, dispensed);
			pstmt.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public RequestLog readRequestLog(int requestID) {
		RequestLog rl = null;
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			
			pstmt = conn.prepareStatement("SELECT * FROM REQUEST_LOG WHERE REQUEST_ID=?");
			pstmt.setInt(1, requestID);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				rl = new RequestLog();
				rl.setLogID(rs.getInt("LOG_ID"));
				rl.setRequestID(rs.getInt("REQUEST_ID"));
				rl.setResponse(rs.getString("RESPONSE"));
				rl.setManagerID(rs.getInt("MANAGER_ID"));
				rl.setStatusID(rs.getInt("STATUS_ID"));
				rl.setDispensed(rs.getInt("DISPENSED"));
			}
			
			return rl;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return rl;
	}
	
	public List<RequestLog> getRequestLogs(int employeeID){
		RequestDaoImpl rdi = new RequestDaoImpl();
		ArrayList<Request> requests = rdi.readResolvedRequests(employeeID);
		List<RequestLog> logs = new ArrayList<RequestLog>();
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			for (Request r : requests) {
				pstmt = conn.prepareStatement("SELECT * FROM REQUEST_LOG WHERE REQUEST_ID=?");
				pstmt.setInt(1, r.getRequestID());
				ResultSet rs = pstmt.executeQuery();
				RequestLog rl = new RequestLog();

				if(rs.next()) {
					rl.setLogID(rs.getInt("LOG_ID"));
					rl.setRequestID(rs.getInt("REQUEST_ID"));
					rl.setResponse(rs.getString("RESPONSE"));
					rl.setManagerID(rs.getInt("MANAGER_ID"));
					rl.setStatusID(rs.getInt("STATUS_ID"));
					rl.setDispensed(rs.getInt("DISPENSED"));
					
					logs.add(rl);
				}
			}
			
			
			
			return logs;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return logs;
	}

}
