package com.revature.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO{
	
	//BE SURE TO USE THE CALLABLE STATEMENT FOR SUBMITTING REIMBURSEMENTS
	@Override
	public void submitReimbursement(User employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reimbursement> empViewPendingReimbursementById(User emp) {
		List<Reimbursement> empPending = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM REIMBURSEMENTS WHERE EMPLOYEE_ID = ? AND STATUS = 1");
			pstmt.setInt(1, emp.getUserId());
			ResultSet results = pstmt.executeQuery();
			while(results.next()) {
				int reimburseId = results.getInt("REIMBURSEMENT_ID");
				// May need to change/convert dates
				Timestamp dateSubmitted = results.getTimestamp("DATE_SUBMITTED");
				String dateSubmit = dateSubmitted.toString();
				int statusId = results.getInt("STATUS");
				double amount = results.getDouble("AMOUNT");
				StatusDAO status = new StatusDAOImpl();
				Blob fileType = results.getBlob("FILE_TYPE");
				empPending.add(new Reimbursement(reimburseId, emp, null, amount, status.getStatusById(statusId), fileType, dateSubmit));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empPending;
	}

	@Override
	public List<Reimbursement> empViewRevolvedReimbursement(User emp) {
		List<Reimbursement> empResolved = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM REIMBURSEMENTS WHERE EMPLOYEE_ID = ? AND STATUS != 1");
			pstmt.setInt(1, emp.getUserId());
			ResultSet results = pstmt.executeQuery();
			while(results.next()) {
				int reimburseId = results.getInt("REIMBURSEMENT_ID");
				// May need to change/convert dates
				Timestamp dateSubmitted = results.getTimestamp("DATE_SUBMITTED");
				String dateSubmit = dateSubmitted.toString();
				double amount = results.getDouble("AMOUNT");
				int statusId = results.getInt("STATUS");
				StatusDAO status = new StatusDAOImpl();
				Blob fileType = results.getBlob("FILE_TYPE");
				UserDAO manager = new UserDAOImpl();
				int managerId = results.getInt("MANAGER_ID");
				empResolved.add(new Reimbursement(reimburseId, emp, manager.getUserById(managerId), amount, status.getStatusById(statusId), fileType, dateSubmit));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empResolved;
	}

	@Override
	public void resolveReimbursement(User manager, int reimburseId, String action) {
		try(Connection conn = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement pstmt = conn.prepareStatement("UPDATE REIMBURSEMENTS SET MANAGER_ID = ?, STATUS = ? WHERE REIMBURSEMENT_ID = ?");
			pstmt.setInt(1, manager.getUserId());
			switch(action) {
			case "approved":
				pstmt.setInt(2, 2);
				break;
			case "declined":
				pstmt.setInt(2, 3);
				break;
			default:
				break;
			}
			pstmt.setInt(3, reimburseId);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Reimbursement> viewAllPendingRequests(User manager) {
		List<Reimbursement> allPending = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM REIMBURSEMENTS WHERE STATUS = 1");
			ResultSet results = pstmt.executeQuery();
			while(results.next()) {
				int reimburseId = results.getInt("REIMBURSEMENT_ID");
				// May need to change/convert dates
				Timestamp dateSubmitted = results.getTimestamp("DATE_SUBMITTED");
				String dateString = dateSubmitted.toString();
				int statusId = results.getInt("STATUS");
				double amount = results.getDouble("AMOUNT");
				StatusDAO status = new StatusDAOImpl();
				Blob fileType = results.getBlob("FILE_TYPE");
				UserDAO employee = new UserDAOImpl();
				int empId = results.getInt("EMPLOYEE_ID");
				allPending.add(new Reimbursement(reimburseId, employee.getUserById(empId), null, amount,status.getStatusById(statusId), fileType, dateString));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allPending;
	}

	@Override
	public List<Reimbursement> viewAllResolvedRequests(User manager) {
		List<Reimbursement> allResolved = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM REIMBURSEMENTS WHERE STATUS != 1");
			ResultSet results = pstmt.executeQuery();
			while(results.next()) {
				int reimburseId = results.getInt("REIMBURSEMENT_ID");
				// May need to change/convert dates
				Timestamp dateSubmitted = results.getTimestamp("DATE_SUBMITTED");
				String dateSubmit = dateSubmitted.toString();
				int statusId = results.getInt("STATUS");
				double amount = results.getDouble("AMOUNT");
				StatusDAO status = new StatusDAOImpl();
				Blob fileType = results.getBlob("FILE_TYPE");
				UserDAO user = new UserDAOImpl();
				int employeeId = results.getInt("EMPLOYEE_ID");
				int managerResolvedId = results.getInt("MANAGER_ID");
				allResolved.add(new Reimbursement(reimburseId, user.getUserById(employeeId), user.getUserById(managerResolvedId), amount, status.getStatusById(statusId), fileType, dateSubmit));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allResolved;
	}

	@Override
	public List<Reimbursement> viewEmpRequests(User manager, int empId) {
		List<Reimbursement> empRequests = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM REIMBURSEMENTS WHERE USER_ID = ?");
			pstmt.setInt(1, empId);
			ResultSet results = pstmt.executeQuery();
			while(results.next()) {
				int reimburseId = results.getInt("REIMBURSEMENT_ID");
				// May need to change/convert dates
				Timestamp dateSubmitted = results.getTimestamp("DATE_SUBMITTED");
				String dateSubmit = dateSubmitted.toString();
				int statusId = results.getInt("STATUS");
				double amount = results.getDouble("AMOUNT");
				StatusDAO status = new StatusDAOImpl();
				Blob fileType = results.getBlob("FILE_TYPE");
				UserDAO user = new UserDAOImpl();
				int managerId = results.getInt("MANAGER_ID");
				// MAY POTENTIALLY BREAK CODE AND NEED TO DEBUG WHEN MANAGER_ID IS NULL
				if(managerId == 0) {
					empRequests.add(new Reimbursement(reimburseId, user.getUserById(empId), null, amount, status.getStatusById(statusId), fileType, dateSubmit));
				} else {
					empRequests.add(new Reimbursement(reimburseId, user.getUserById(empId), user.getUserById(managerId), amount, status.getStatusById(statusId), fileType, dateSubmit));
				}
								
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empRequests;
	}

}
