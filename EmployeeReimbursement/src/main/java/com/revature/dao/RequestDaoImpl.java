package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Request;
import com.revature.util.ConnectionUtil;


public class RequestDaoImpl implements RequestDao {

	
	@Override
	public int createRequest(int empID, Date dateSubmitted, String description, double amount) {

		
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO REQUEST "
					+ "(EMPLOYEE_ID,DATE_SUBMITTED,STATUS_ID,DESCRIPTION,AMOUNT)"
					+ " VALUES (?,?,?,?,?)");

			pstmt.setInt(1, empID);
			pstmt.setDate(2, dateSubmitted);
			pstmt.setInt(3, 1);	//1 - NOT SUBMITTED
			pstmt.setString(4, description);
			pstmt.setDouble(5, amount);
			pstmt.executeUpdate();
			
			
			pstmt = conn.prepareStatement("SELECT MAX(REQUEST_ID) FROM REQUEST WHERE EMPLOYEE_ID=?");

			pstmt.setInt(1, empID);
			ResultSet rs = pstmt.executeQuery();
			int insertedRequestID = -1;
			
			if(rs.next()) {
				insertedRequestID = rs.getInt(1);
			}
			
			return insertedRequestID;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	
	@Override
	public Request readRequestById(int reqID) {
		Request request = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE REQUEST_ID=?");
			pstmt.setInt(1, reqID);
			rs = pstmt.executeQuery();
			
			Request currReq = null;
			if(rs.next()) {
				currReq = new Request(rs.getInt("REQUEST_ID"), rs.getInt("EMPLOYEE_ID"), 
									rs.getDate("DATE_SUBMITTED"), rs.getInt("STATUS_ID"), 
									rs.getString("DESCRIPTION"), rs.getDouble("AMOUNT"));
				request = currReq;
			}
			
			return request;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return request;
	}
	
	
	@Override
	public ArrayList<Request> readPendingRequests(int empID) {
		ArrayList<Request> requestArrList = new ArrayList<Request>();
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE EMPLOYEE_ID=? AND STATUS_ID=?");
			pstmt.setInt(1, empID);
			pstmt.setInt(2, 1);			//STATUS is 1 when request is still pending
			rs = pstmt.executeQuery();
			
			Request currReq = null;
			while(rs.next()) {
				currReq = new Request(rs.getInt("REQUEST_ID"), rs.getInt("EMPLOYEE_ID"), 
									rs.getDate("DATE_SUBMITTED"), rs.getInt("STATUS_ID"), 
									rs.getString("DESCRIPTION"), rs.getDouble("AMOUNT"));
				requestArrList.add(currReq);
			}
			
			return requestArrList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return requestArrList;
	}

	
	@Override
	public ArrayList<Request> readResolvedRequests(int empID) {
		ArrayList<Request> requestArrList = new ArrayList<Request>();
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE EMPLOYEE_ID=? AND STATUS_ID=? OR STATUS_ID=?");
			pstmt.setInt(1, empID);
			pstmt.setInt(2, 2);			//STATUS is 2 or 3 when request is completed
			pstmt.setInt(3, 3);
			rs = pstmt.executeQuery();
			
			Request currReq = null;
			while(rs.next()) {
				currReq = new Request(rs.getInt("REQUEST_ID"), rs.getInt("EMPLOYEE_ID"), 
									rs.getDate("DATE_SUBMITTED"), rs.getInt("STATUS_ID"), 
									rs.getString("DESCRIPTION"), rs.getDouble("AMOUNT"));
				requestArrList.add(currReq);
			}
			
			return requestArrList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return requestArrList;
	}
	
	public ArrayList<Request> readAllRequests(int empID){
		ArrayList<Request> requestArrList = new ArrayList<Request>();
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE EMPLOYEE_ID=?");
			pstmt.setInt(1, empID);
			rs = pstmt.executeQuery();
			
			Request currReq = null;
			while(rs.next()) {
				currReq = new Request(rs.getInt("REQUEST_ID"), rs.getInt("EMPLOYEE_ID"), 
									rs.getDate("DATE_SUBMITTED"), rs.getInt("STATUS_ID"), 
									rs.getString("DESCRIPTION"), rs.getDouble("AMOUNT"));
				requestArrList.add(currReq);
			}
			
			return requestArrList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return requestArrList;
	}

	
	public ArrayList<Request> readAllPendingRequests(){
		ArrayList<Request> requestArrList = new ArrayList<Request>();
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE STATUS_ID=?");
			pstmt.setInt(1, 1);			//STATUS is 1 when request is still pending
			rs = pstmt.executeQuery();
			
			Request currReq = null;
			while(rs.next()) {
				currReq = new Request(rs.getInt("REQUEST_ID"), rs.getInt("EMPLOYEE_ID"), 
									rs.getDate("DATE_SUBMITTED"), rs.getInt("STATUS_ID"), 
									rs.getString("DESCRIPTION"), rs.getDouble("AMOUNT"));
				requestArrList.add(currReq);
			}
			
			return requestArrList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return requestArrList;
	}
	
	
	public ArrayList<Request> readAllResolvedRequests(){
		ArrayList<Request> requestArrList = new ArrayList<Request>();
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE STATUS_ID=? OR STATUS_ID=? ORDER BY DATE_SUBMITTED DESC");
			pstmt.setInt(1, 2);			
			pstmt.setInt(2, 3);
			rs = pstmt.executeQuery();
			
			Request currReq = null;
			while(rs.next()) {
				currReq = new Request(rs.getInt("REQUEST_ID"), rs.getInt("EMPLOYEE_ID"), 
									rs.getDate("DATE_SUBMITTED"), rs.getInt("STATUS_ID"), 
									rs.getString("DESCRIPTION"), rs.getDouble("AMOUNT"));
				requestArrList.add(currReq);
			}
			
			return requestArrList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return requestArrList;
	}
	
	
	@Override
	public Request updateRequest(int reqId, int newStatus) {
		Request currReq = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = conn.prepareStatement("UPDATE REQUEST "
					+ "SET STATUS_ID=? "
					+ "WHERE REQUEST_ID=?");
			pstmt.setInt(1, newStatus);
			pstmt.setInt(2, reqId);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE REQUEST_ID=?");
			pstmt.setInt(1, reqId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				currReq = new Request(rs.getInt("REQUEST_ID"), rs.getInt("EMPLOYEE_ID"),
						rs.getDate("DATE_SUBMITTED"), rs.getInt("STATUS_ID"),
						rs.getString("DESCRIPTION"), rs.getDouble("AMOUNT"));
				return currReq;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return currReq;
	}

}
