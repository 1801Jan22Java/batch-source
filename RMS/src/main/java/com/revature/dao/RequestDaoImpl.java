package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.revature.beans.Request;
import com.revature.util.ConnectionUtil;

public class RequestDaoImpl implements RequestDao {

	@Override
	public void submit(Request request) throws Exception {
		String sql = "INSERT INTO Request (EmployeeID, Amount, Description, FileName) VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt = ConnectionUtil.getConnection().prepareStatement(sql);
		pstmt.setInt(1, request.getEmployeeID());
		pstmt.setFloat(2, request.getAmount());
		pstmt.setString(3, request.getDescription());
		pstmt.setString(4, request.getFilename());
		pstmt.executeUpdate();
	}

	@Override
	public ArrayList<Request> viewPending(int empID, int isManager) throws Exception {
		String sql;
		PreparedStatement pstmt;
		Connection conn = ConnectionUtil.getConnection();
		ArrayList<Request> list = new ArrayList<Request>();
		if(isManager == 0) {
			sql = "SELECT * FROM Request WHERE EmployeeID = ? AND Status = 'Pending'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empID);
		} else {
			sql = "SELECT * FROM Request WHERE Status = 'Pending'";
			pstmt = conn.prepareStatement(sql);
		}
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Request req = new Request(rs.getInt("RequestID"), rs.getInt("EmployeeID"), rs.getFloat("Amount"), rs.getString("Description"),
					rs.getString("FileName"), rs.getTimestamp("DateOf"), rs.getString("Status"), rs.getInt("ManagerID"));
			list.add(req);
		}
		return list;
	}

	@Override
	public ArrayList<Request> viewResolved(int empID, int isManager) throws Exception {
		String sql;
		PreparedStatement pstmt;
		Connection conn = ConnectionUtil.getConnection();
		ArrayList<Request> list = new ArrayList<Request>();
		if(isManager == 0) {
			sql = "SELECT * FROM Request WHERE EmployeeID = ? AND Status IN ('Pending', 'Denied')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empID);
		} else {
			sql = "SELECT * FROM Request WHERE Status IN ('Approved', 'Denied')";
			pstmt = conn.prepareStatement(sql);
		}
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Request req = new Request(rs.getInt("RequestID"), rs.getInt("EmployeeID"), rs.getFloat("Amount"), rs.getString("Description"),
					rs.getString("FileName"), rs.getTimestamp("DateOf"), rs.getString("Status"), rs.getInt("ManagerID"));
			list.add(req);
		}
		return list;
	}

	@Override
	public void update(int requestID, String status, int managerID) throws Exception {
		String sql = "UPDATE Request SET Status = ?, ManagerID = ? WHERE RequestID = ?";
		PreparedStatement pstmt = ConnectionUtil.getConnection().prepareStatement(sql);
		pstmt.setString(1, status);
		pstmt.setInt(2, managerID);
		pstmt.setInt(3, requestID);
	}

}
