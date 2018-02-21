package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.ReimbReq;
import com.revature.util.ConnectionUtil;

public class ReimbReqDAOImpl implements ReimbReqDAO {

	/*
	 * (non-Javadoc)
	 * @see com.revature.dao.ReimbReqDAO#addNewReimbReq(int, java.lang.String, java.lang.String)
	 * To add new reimbursement request using Id, 'pending', 'receipt'
	 * ReqId NOT NULL, ReqName NOT NULL, Amount NOT NULL, EmployeeId NOT NULL, ReqStatus, Receipt, ModByManagerId
	 */
	@Override
	public int addNewReimbReq(String reqName, double amount, int employeeId, String reqStatus, String receipt) {
		int reimbReqCreated = 0;
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "INSERT INTO ReimbReq (ReqName, Amount, EmployeeId, ReqStatus, Receipt) VALUES (?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reqName);
			pstmt.setDouble(2, amount);
			pstmt.setInt(3, employeeId);
			pstmt.setString(4, reqStatus);
			pstmt.setString(5, receipt);
			reimbReqCreated = pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reimbReqCreated;
	}
	
	/* 
	 * Get ALL PENDING request
	 * ReqId NOT NULL, ReqName NOT NULL, Amount NOT NULL, EmployeeId NOT NULL, ReqStatus, Receipt, ModByManagerId
	 */
	@Override
	public List<ReimbReq> getAllPendingReq() {
		List<ReimbReq> allPendingReq = new ArrayList<>();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM ReimbReq WHERE ReqStatus = 'pending'";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reqId = rs.getInt("ReqId");
				String reqName = rs.getString("ReqName");
				double amount = rs.getDouble("Amount");
				int employeeId = rs.getInt("EmployeeId");
				String reqStatus = rs.getString("ReqStatus");
				String receipt = rs.getString("Receipt");
				int modByManagerId = rs.getInt("ModByManagerId");
				allPendingReq.add(new ReimbReq(reqId, reqName, amount, employeeId, reqStatus, receipt, modByManagerId));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return allPendingReq;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.revature.dao.ReimbReqDAO#getPendingReimb(int)
	 * Get rows of PENDING requests by employee Id.
	 */
	@Override
	public List<ReimbReq> getPendingReimb(int employeeId) {
		List<ReimbReq> pendingReq = new ArrayList<>();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM ReimbReq WHERE ReqStatus = 'pending' AND EmployeeId = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reqId = rs.getInt("ReqId");
				String reqName = rs.getString("ReqName");
				double amount = rs.getDouble("Amount");
				String reqStatus = rs.getString("ReqStatus");
				String receipt = rs.getString("Receipt");
				int modByManagerId = rs.getInt("ModByManagerId");
				pendingReq.add(new ReimbReq(reqId, reqName, amount, employeeId, reqStatus, receipt, modByManagerId));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return pendingReq;
	}

	// ALL RESOLVED
	@Override
	public List<ReimbReq> getAllResolvedReq() {
		List<ReimbReq> allResolvedReq = new ArrayList<>();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM ReimbReq WHERE ReqStatus = 'resolved'";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reqId = rs.getInt("ReqId");
				String reqName = rs.getString("ReqName");
				double amount = rs.getDouble("Amount");
				int employeeId = rs.getInt("EmployeeId");
				String reqStatus = rs.getString("ReqStatus");
				String receipt = rs.getString("Receipt");
				int modByManagerId = rs.getInt("ModByManagerId");
				allResolvedReq.add(new ReimbReq(reqId, reqName, amount, employeeId, reqStatus, receipt, modByManagerId));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return allResolvedReq;
	}

	// Get an employee's "resolved" reimbursement request by employeeId
	@Override
	public List<ReimbReq> getResolvedReimb(int employeeId) {
		List<ReimbReq> resolvedReq = new ArrayList<>();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM ReimbReq WHERE ReqStatus = 'resolved' AND EmployeeId = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reqId = rs.getInt("ReqId");
				String reqName = rs.getString("ReqName");
				double amount = rs.getDouble("Amount");
				String reqStatus = rs.getString("ReqStatus");
				String receipt = rs.getString("Receipt");
				int modByManagerId = rs.getInt("ModByManagerId");
				resolvedReq.add(new ReimbReq(reqId, reqName, amount, employeeId, reqStatus, receipt, modByManagerId));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return resolvedReq;
	}

	@Override
	public int updateStatus(String reqStatus) {
		// TODO Auto-generated method stub
		return 0;
	}


}
