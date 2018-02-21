package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Manager;
import com.revature.beans.Request;
import com.revature.beans.RequestStatus;
import com.revature.beans.ResolvedRequest;
import com.revature.util.ConnectionUtil;

public class ResolvedRequestDaoImpl implements ResolvedRequestDao {

	@Override
	public List<ResolvedRequest> getAllResolvedRequests() {
		List<ResolvedRequest> resolvedRequestList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ManagerDaoImpl mdi = new ManagerDaoImpl();
		RequestDaoImpl rdi = new RequestDaoImpl();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		RequestStatusDaoImpl rsdi = new RequestStatusDaoImpl();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM RESOLVED_REQUEST";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int resolvedRequestId = rs.getInt("RESOLVED_REQUEST_ID");
				int managerId = rs.getInt("MANAGER_ID");
				Manager manager = mdi.getManagerById(managerId);
				int requestId = rs.getInt("REQUEST_ID");
				Request request = rdi.getRequestById(requestId);
				int employeeId = rs.getInt("EMPLOYEE_ID");
				Employee employee = edi.getEmployeeById(employeeId);
				int requestStatusId = rs.getInt("REQUEST_STATUS_ID");
				RequestStatus requestStatus = rsdi.getRequestStatusById(requestStatusId);
				double requestAmount = rs.getDouble("REQUEST_AMOUNT");
				String requestComment = rs.getString("REQUEST_COMMENT");

				resolvedRequestList.add(new ResolvedRequest(resolvedRequestId, manager, request, 
						employee, requestStatus, requestAmount, requestComment));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return resolvedRequestList;
	}

	@Override
	public List<ResolvedRequest> getResolvedRequestsByEmployeeId(int employeeId) {
		List<ResolvedRequest> resolvedRequestList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ManagerDaoImpl mdi = new ManagerDaoImpl();
		RequestDaoImpl rdi = new RequestDaoImpl();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		RequestStatusDaoImpl rsdi = new RequestStatusDaoImpl();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM RESOLVED_REQUEST WHERE EMPLOYEE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int resolvedRequestId = rs.getInt("RESOLVED_REQUEST_ID");
				int managerId = rs.getInt("MANAGER_ID");
				Manager manager = mdi.getManagerById(managerId);
				int requestId = rs.getInt("REQUEST_ID");
				Request request = rdi.getRequestById(requestId);
				Employee employee = edi.getEmployeeById(employeeId);
				int requestStatusId = rs.getInt("REQUEST_STATUS_ID");
				RequestStatus requestStatus = rsdi.getRequestStatusById(requestStatusId);
				double requestAmount = rs.getDouble("REQUEST_AMOUNT");
				String requestComment = rs.getString("REQUEST_COMMENT");

				resolvedRequestList.add(new ResolvedRequest(resolvedRequestId, manager, request, 
						employee, requestStatus, requestAmount, requestComment));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return resolvedRequestList;
	}

	@Override 
	public void approvePendingRequest(int requestId, int managerId) {
		CallableStatement cs = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "{CALL SP_APPROVE_PENDING_REQUEST(?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1,requestId);
			cs.setInt(2, managerId);
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override 
	public void denyPendingRequest(int requestId, int managerId) {
		CallableStatement cs = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "{CALL SP_DENY_PENDING_REQUEST(?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1,requestId);
			cs.setInt(2, managerId);
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
