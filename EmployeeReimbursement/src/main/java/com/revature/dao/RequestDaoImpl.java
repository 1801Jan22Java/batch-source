package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.util.ConnectionUtil;

public class RequestDaoImpl implements RequestDao {

	public static final String filename = "connection.properties";

	public void addRequest(Request req) {
		
		try {
			int employeeID = req.getEmployeeID();
			Integer resolveID = req.getManagerID(); // wrapper class b/c database field is nullable
			Double amount = req.getAmount();
			String status = req.getStatus();
			String message = req.getDescription();
			String reply = req.getReply();
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "INSERT INTO REQUEST (EmpID, ResolveID, Amount, "
						+ "Status, Message, Reply) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employeeID);
			ps.setInt(2, resolveID);
			ps.setDouble(3, amount);
			ps.setString(4, status);
			ps.setString(5, message);
			ps.setString(6, reply);
			ps.executeUpdate();
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateRequest(int id) {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Request> getEmployeeRequests(int eid) {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<Request> getAllRequests() {
		ArrayList<Request> requests;
		try {
			requests = new ArrayList<Request>();
			int requestID = 0;
			int employeeID = 0;
			Integer resolveID; // wrapper class b/c database field is nullable
			Double amount = 0.0;
			LocalDate whenRequested;
			String status;
			String message;
			String reply;
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM REQUEST";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				requestID = rs.getInt("RID");
				employeeID = rs.getInt("EmpID");
				resolveID = rs.getInt("ResolveID");
				amount = rs.getDouble("Amount");
				whenRequested = rs.getDate("whenMade").toLocalDate();
				status = rs.getString("Status");
				message = rs.getString("Message");
				reply = rs.getString("Reply");
				
				requests.add(new Request(requestID, employeeID, resolveID,
										amount, message, reply, status, whenRequested));
			}
			
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void revokeRequest(int id, Employee emp) {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void resolveRequest(int id) {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
