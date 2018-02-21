package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Request;
import com.revature.util.ConnectionUtil;

public class RequestDaoImpl implements RequestDao{

	@Override
	public List<Request> getRequests(int id) {

		Connection connection;
		List<Request> requests = new ArrayList<Request>();
		
		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "SELECT * FROM ERS_REQUEST WHERE EMP_ID=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				requests.add(new Request(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getString(5), rs.getTimestamp(6), rs.getBlob(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return requests;
	}

	@Override
	public void createRequest(Request request) {
		Connection connection;
		
		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "INSERT INTO ERS_REQUEST VALUES(REQUEST_ID_SEQUENCE.NEXTVAL,?,?,?,?,CURRENT_TIMESTAMP,?,?,0, -1)";
			//int reqId, int empID, String title, String description, Date date, Blob reciept
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, request.getEmpID());
			statement.setString(2, request.getTitle());
			statement.setFloat(3, request.getAmount());
			statement.setString(4, request.getDescription());
			statement.setBlob(5, request.getReciept());
			statement.setInt(6, request.getWalletID());
			statement.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Request> getRequests() {
		Connection connection;
		List<Request> requests = new ArrayList<Request>();
		
		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "SELECT * FROM ERS_REQUEST";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				requests.add(new Request(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getString(5), rs.getTimestamp(6), rs.getBlob(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return requests;
	}

	@Override
	public void ApproveRequest(int id, int manID) {
		
		Connection connection;
		
		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "UPDATE ERS_REQUEST SET STATUS=1, MANAGER_ID=? WHERE REQUEST_ID=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(2, id);
			statement.setInt(1, manID);
			statement.executeQuery();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void DenyRequest(int id, int manID) {
	
Connection connection;
		
		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "UPDATE ERS_REQUEST SET STATUS=2, MANAGER_ID=? WHERE REQUEST_ID=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(2, id);
			statement.setInt(1, manID);
			statement.executeQuery();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Request GetRequest(int id) {
		Connection connection;
		
		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "SELECT * FROM ERS_REQUEST WHERE REQUEST_ID=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				return new Request(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getString(5), rs.getTimestamp(6), rs.getBlob(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return null;
	}

}
