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
	 */
	@Override
	public int addNewReimbReq(String reqName, int employeeId, String reqStatus) {
		int reimbReqCreated = 0;
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "INSERT INTO ReimbReq (ReqName, EmployeeId, ReqStatus) VALUES (?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reqName);
			pstmt.setInt(2, employeeId);
			pstmt.setString(3, reqStatus);
//			pstmt.setString(3, receipt); 
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
				int employeeId = rs.getInt("EmployeeId");
				int modByManagerId = rs.getInt("ModByManagerId");
				String reqStatus = rs.getString("ReqStatus");
				String receipt = "receipt"; // rs.getString("Receipt");
				allPendingReq.add(new ReimbReq(reqId, reqName, employeeId, modByManagerId, reqStatus, receipt));
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
				int modByManagerId = rs.getInt("ModByManagerId");
				String reqStatus = rs.getString("ReqStatus");
				String receipt = "receipt";  //rs.getString("Receipt");
				pendingReq.add(new ReimbReq(reqId, reqName, employeeId, modByManagerId, reqStatus, receipt));
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
				int employeeId = rs.getInt("EmployeeId");
				int modByManagerId = rs.getInt("ModByManagerId");
				String reqStatus = rs.getString("ReqStatus");
				String receipt = "receipt"; //rs.getString("Receipt");
				allResolvedReq.add(new ReimbReq(reqId, reqName, employeeId, modByManagerId, reqStatus, receipt));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return allResolvedReq;
	}

	// Get "resolved" reimbursement request by employeeId
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
				int modByManagerId = rs.getInt("ModByManagerId");
				String reqStatus = rs.getString("ReqStatus");
				String receipt = "receipt";  //rs.getString("Receipt");
				resolvedReq.add(new ReimbReq(reqId, reqName, employeeId, modByManagerId, reqStatus, receipt));
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
