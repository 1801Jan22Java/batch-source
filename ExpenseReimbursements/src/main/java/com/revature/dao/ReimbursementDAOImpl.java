package com.revature.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
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
	
	@Override
	public void submitReimbursement(User employee, InputStream fileName, double amount) {
		try {
			System.out.println(fileName.available());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try(Connection conn = ConnectionUtil.getConnectionFromFile()){
			String sql = "{call ADDREIMBURSEMENT(?, ?, ?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setBlob(1, fileName);
			cstmt.setDouble(2, amount);
			cstmt.setInt(3, employee.getUserId());
			cstmt.execute();
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
				empPending.add(new Reimbursement(reimburseId, emp, null, amount, status.getStatusById(statusId), dateSubmit));
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
				UserDAO manager = new UserDAOImpl();
				int managerId = results.getInt("MANAGER_ID");
				//TODO MAKING FILETYPE NULL FOR NOW
				empResolved.add(new Reimbursement(reimburseId, emp, manager.getUserById(managerId), amount, status.getStatusById(statusId), dateSubmit));
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
				UserDAO employee = new UserDAOImpl();
				int empId = results.getInt("EMPLOYEE_ID");
				allPending.add(new Reimbursement(reimburseId, employee.getUserById(empId), null, amount,status.getStatusById(statusId), dateString));
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
				UserDAO user = new UserDAOImpl();
				int employeeId = results.getInt("EMPLOYEE_ID");
				int managerResolvedId = results.getInt("MANAGER_ID");
				allResolved.add(new Reimbursement(reimburseId, user.getUserById(employeeId), user.getUserById(managerResolvedId), amount, status.getStatusById(statusId), dateSubmit));
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
				UserDAO user = new UserDAOImpl();
				int managerId = results.getInt("MANAGER_ID");
				// MAY POTENTIALLY BREAK CODE AND NEED TO DEBUG WHEN MANAGER_ID IS NULL
				if(managerId == 0) {
					empRequests.add(new Reimbursement(reimburseId, user.getUserById(empId), null, amount, status.getStatusById(statusId), dateSubmit));
				} else {
					empRequests.add(new Reimbursement(reimburseId, user.getUserById(empId), user.getUserById(managerId), amount, status.getStatusById(statusId), dateSubmit));
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

	@Override
	public ByteArrayOutputStream getRequestImage(int reimburseId) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		try(Connection conn = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement pstmt = conn.prepareStatement("SELECT FILE_TYPE FROM REIMBURSEMENTS WHERE REIMBURSEMENT_ID = ?");
			pstmt.setInt(1, reimburseId);
			ResultSet results = pstmt.executeQuery();
			while(results.next()) {
				Blob fileType = results.getBlob("FILE_TYPE");
				InputStream inStream = fileType.getBinaryStream();
				int nRead;
				byte[] data = new byte [100000];
				
				while((nRead = inStream.read(data, 0 ,data.length)) != -1) {
					buffer.write(data, 0, nRead);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buffer;
	}

}
