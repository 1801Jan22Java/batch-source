package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.revature.beans.Request;
import com.revature.util.ConnectionUtil;

public class RequestDaoImpl implements RequestDao{
	
	private static String filename = "connection.properties";

	//Creates a Request Object
	public int createRequest(int requestID, int empID, int typeID, int statusID, String description, double amount, LocalDate statusDate,
				LocalDate submitDate, int manID) {
		int reqVal = 0;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "INSERT INTO REQUEST (REQUEST_ID, EMPLOYEE_ID, TYPE_ID, STATUS_ID, "
					+ "DESCRIPTION, AMOUNT, STATUS_DATE, SUBMIT_DATE, MANAGER_ID)" +
			" VALUES (REQ_NUM_SEQ.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE, SYSDATE, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  empID);
			pstmt.setInt(2,  typeID);
			pstmt.setInt(3,  statusID);
			pstmt.setString(4,  description);
			pstmt.setDouble(5,  amount);
			pstmt.setInt(6,  manID);
			reqVal = pstmt.executeUpdate();
		con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return reqVal;

	}

	//Retrieves a Request by ID
	public Request getReqByID(int reqID) {
		PreparedStatement pstmt = null;
		Request request = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM REQUEST WHERE REQUEST_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reqID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int rID = rs.getInt("REQUEST_ID");
				int empID = rs.getInt("EMPLOYEE_ID");
				int typeID = rs.getInt("TYPE_ID");
				int statID = rs.getInt("STATUS_ID");
				String desc = rs.getString("DESCRIPTION");
				int amnt = rs.getInt("AMOUNT");
				LocalDate statDate = rs.getDate("STATUS_DATE").toLocalDate();
				LocalDate subDate = rs.getDate("SUBMIT_DATE").toLocalDate();
				int mID = rs.getInt("MANAGER_ID");
				request = new Request(rID, empID, typeID, statID, desc, amnt, statDate, subDate, mID);
			}
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		return request;
	}

	//Changes the request status of a Request
	public Request modifyReqStatus(int statID, Request req) {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "UPDATE REQUEST SET STATUS_ID = ? WHERE REQUEST_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, statID);
			pstmt.setInt(2, req.getRequestID());
			pstmt.executeUpdate();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return req;
	}

	//Returns all Requests that are not yet processed 
	public ArrayList<Request> getIncompleteRequests() {
		Connection con = null;
		ArrayList<Request> pendReqs = new ArrayList<Request>();
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM REQUEST WHERE STATUS_ID < 4";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reqID = rs.getInt("REQUEST_ID");
				int empID = rs.getInt("EMPLOYEE_ID");
				int typeID = rs.getInt("TYPE_ID");
				int statID = rs.getInt("STATUS_ID");
				String desc = rs.getString("DESCRIPTION");
				double amount = rs.getDouble("AMOUNT");
				LocalDate statDate = rs.getDate("STATUS_DATE").toLocalDate();
				LocalDate subDate = rs.getDate("SUBMIT_DATE").toLocalDate();
				int mID = rs.getInt("MANAGER_ID");
				pendReqs.add(new Request(reqID, empID, typeID, statID, desc, amount, statDate, subDate, mID));
			}
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return pendReqs;
	}

	//Returns all Requests that are completed
	public ArrayList<Request> getCompleteRequests() {
		Connection con = null;
		ArrayList<Request> finReqs = new ArrayList<Request>();
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM REQUEST WHERE STATUS_ID > 3";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reqID = rs.getInt("REQUEST_ID");
				int empID = rs.getInt("EMPLOYEE_ID");
				int typeID = rs.getInt("TYPE_ID");
				int statID = rs.getInt("STATUS_ID");
				String desc = rs.getString("DESCRIPTION");
				double amount = rs.getDouble("AMOUNT");
				LocalDate statDate = rs.getDate("STATUS_DATE").toLocalDate();
				LocalDate subDate = rs.getDate("SUBMIT_DATE").toLocalDate();
				int mID = rs.getInt("MANAGER_ID");
				finReqs.add(new Request(reqID, empID, typeID, statID, desc, amount, statDate, subDate, mID));
			}
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return finReqs;
	}

	//Retrieves all Requests made by a single Employee
	public ArrayList<Request> getRequestsByEmployee(int empID) {
		PreparedStatement pstmt = null;
		ArrayList<Request> empReqs = new ArrayList<Request>();
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM REQUEST WHERE EMPLOYEE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reqID = rs.getInt("REQUEST_ID");
				int eID = rs.getInt("EMPLOYEE_ID");
				int typeID = rs.getInt("TYPE_ID");
				int statID = rs.getInt("STATUS_ID");
				String desc = rs.getString("DESCRIPTION");
				int amnt = rs.getInt("AMOUNT");
				LocalDate statDate = rs.getDate("STATUS_DATE").toLocalDate();
				LocalDate subDate = rs.getDate("SUBMIT_DATE").toLocalDate();
				int mID = rs.getInt("MANAGER_ID");
				empReqs.add(new Request(reqID, eID, typeID, statID, desc, amnt, statDate, subDate, mID));
			}
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		return empReqs;
	}

}
