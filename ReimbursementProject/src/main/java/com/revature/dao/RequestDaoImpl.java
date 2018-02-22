package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.beans.RequestStatus;
import com.revature.util.ConnectionUtil;

public class RequestDaoImpl implements RequestDao {

	@Override
	public List<Request> getAllPendingRequests() {		
		List<Request> requestList = new ArrayList<>();
		PreparedStatement pstmt = null;
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		RequestStatusDaoImpl rsdi = new RequestStatusDaoImpl();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM REQUEST WHERE REQUEST_STATUS_ID = 1 ORDER BY REQUEST_ID";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int requestId = rs.getInt("REQUEST_ID");
				int employeeId = rs.getInt("EMPLOYEE_ID");
				Employee employee = edi.getEmployeeById(employeeId);
				int requestStatusId = rs.getInt("REQUEST_STATUS_ID");
				RequestStatus requestStatus = rsdi.getRequestStatusById(requestStatusId);
				double requestAmount = rs.getDouble("REQUEST_AMOUNT");
				String requestComment = rs.getString("REQUEST_COMMENT");

				requestList.add(new Request(requestId, employee, requestStatus, requestAmount, requestComment));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return requestList;
	}

	@Override
	public List<Request> getPendingRequestsByEmployeeId(int employeeId) {
		List<Request> requestList = new ArrayList<>();
		PreparedStatement pstmt = null;
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		RequestStatusDaoImpl rsdi = new RequestStatusDaoImpl();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM REQUEST WHERE EMPLOYEE_ID = ? AND REQUEST_STATUS_ID = 1 ORDER BY REQUEST_ID";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int requestId = rs.getInt("REQUEST_ID");
				Employee employee = edi.getEmployeeById(employeeId);
				int requestStatusId = rs.getInt("REQUEST_STATUS_ID");
				RequestStatus requestStatus = rsdi.getRequestStatusById(requestStatusId);
				double requestAmount = rs.getDouble("REQUEST_AMOUNT");
				String requestComment = rs.getString("REQUEST_COMMENT");

				requestList.add(new Request(requestId, employee, requestStatus, requestAmount, requestComment));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return requestList;
	}

	@Override	// INSERT
	public void submitNewRequest(int employeeId, double requestAmount, String requestComment) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "INSERT INTO REQUEST (EMPLOYEE_ID, REQUEST_STATUS_ID, REQUEST_AMOUNT, REQUEST_COMMENT) " + 
					"VALUES (?, 1, ?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			pstmt.setDouble(2, requestAmount);
			pstmt.setString(3, requestComment);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Request> getAllRequests() {
		List<Request> requestList = new ArrayList<>();
		PreparedStatement pstmt = null;
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		RequestStatusDaoImpl rsdi = new RequestStatusDaoImpl();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM REQUEST ORDER BY EMPLOYEE_ID";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int requestId = rs.getInt("REQUEST_ID");
				int employeeId = rs.getInt("EMPLOYEE_ID");
				Employee employee = edi.getEmployeeById(employeeId);
				int requestStatusId = rs.getInt("REQUEST_STATUS_ID");
				RequestStatus requestStatus = rsdi.getRequestStatusById(requestStatusId);
				double requestAmount = rs.getDouble("REQUEST_AMOUNT");
				String requestComment = rs.getString("REQUEST_COMMENT");

				requestList.add(new Request(requestId, employee, requestStatus, requestAmount, requestComment));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return requestList;
	}

	@Override
	public Request getRequestById(int requestId) {
		Request request = null;
		PreparedStatement pstmt = null;
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		RequestStatusDaoImpl rsdi = new RequestStatusDaoImpl();
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM REQUEST WHERE REQUEST_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, requestId);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()){
				int employeeId = rs.getInt("EMPLOYEE_ID");
				Employee employee = edi.getEmployeeById(employeeId);
				int requestStatusId = rs.getInt("REQUEST_STATUS_ID");
				RequestStatus requestStatus = rsdi.getRequestStatusById(requestStatusId);
				double requestAmount = rs.getDouble("REQUEST_AMOUNT");
				String requestComment = rs.getString("REQUEST_COMMENT");

				request = new Request(requestId, employee, requestStatus, requestAmount, requestComment);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return request;
	}

}
