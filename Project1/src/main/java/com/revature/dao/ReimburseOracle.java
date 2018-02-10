package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimburseOracle implements ReimburseDAO {
	// Instantiate connection once.
	Connection con;
	private String filename = "connection.properties";

	// Connection
	public ReimburseOracle() {
		try {
			con = ConnectionUtil.getConnectionFromFile(this.filename);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Reimbursement> viewPendingRequests(int user_id) {
		String sql = "";
		if (user_id == 0) {
			sql = "SELECT * FROM REIMBURSE_REQUEST WHERE REIMBURSE_STATUS_ID = 1";
		} else {
			sql = "SELECT * FROM REIMBURSE_REQUEST WHERE USER_ID = ? AND REIMBURSE_STATUS_ID = 1";
		}
		List<Reimbursement> reim = new ArrayList<>();
		try {

			PreparedStatement ps = con.prepareStatement(sql);
			if (user_id != 0) {
				ps.setInt(1, user_id);
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int rr_id = rs.getInt("REIMBURSE_REQUEST_ID");
				int uid = rs.getInt("USER_ID");
				double amount = rs.getDouble("amount");
				int rs_id = rs.getInt("REIMBURSE_STATUS_ID");
				String notes = rs.getString("NOTES");
				int resolved_by = rs.getInt("RESOLVED_BY");
				reim.add(new Reimbursement(rr_id, rs_id, uid, amount, notes, resolved_by));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reim;
	}

	@Override
	public List<Reimbursement> viewResolvedRequests(int user_id) {
		String sql = "";
		if (user_id == 0) {
			sql = "SELECT * FROM REIMBURSE_REQUEST WHERE REIMBURSE_STATUS_ID > 1";
		} else {
			sql = "SELECT * FROM REIMBURSE_REQUEST WHERE USER_ID = ? AND REIMBURSE_STATUS_ID > 1";
		}

		List<Reimbursement> reim = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			if (user_id != 0) {
				ps.setInt(1, user_id);
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int rr_id = rs.getInt("REIMBURSE_REQUEST_ID");
				int uid = rs.getInt("USER_ID");
				double amount = rs.getDouble("amount");
				int rs_id = rs.getInt("REIMBURSE_STATUS_ID");
				String notes = rs.getString("NOTES");
				int resolved_by = rs.getInt("RESOLVED_BY");
				reim.add(new Reimbursement(rr_id, rs_id, uid, amount, notes, resolved_by));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reim;
	}

//	private double getAmount(int request_id) {
//		String sql = "SELECT AMOUNT FROM REIMBURSE_REQUEST WHERE REIMBURSE_REQUEST_ID=?";
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			ps.setInt(1, request_id);
//			while (rs.next()) {
//				return rs.getDouble("AMOUNT");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return 0.0;
//	}


	@Override
	public boolean reimburseRequest(int user_id, double amount, String notes) {
		String dml = "INSERT INTO REIMBURSE_REQUEST (USER_ID, AMOUNT, NOTES) VALUES (?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(dml);
			ps.setInt(1, user_id);
			ps.setDouble(2, amount);
			ps.setString(3, notes);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean uploadImage(String filename) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void viewImage(int request_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean approveRequest(int request_id, double amount, int manager_id) {
		if(amount < 0.0) {
			return false;
		}
		String dml = "UPDATE REIMBURSE_REQUEST SET REIMBURSE_STATUS_ID = 3, AMOUNT_APPROVED = ?, RESOLVED_BY = ? WHERE REIMBURSE_REQUEST_ID = ?";
		try {
			PreparedStatement ps = con.prepareStatement(dml);
			ps.setDouble(1, amount);
			ps.setInt(2, manager_id);
			ps.setInt(3, request_id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean denyRequest(int request_id, int manager_id) {
		String dml = "UPDATE REIMBURSE_REQUEST SET REIMBURSE_STATUS_ID = 2, RESOLVED_BY = ? WHERE REIMBURSE_REQUEST_ID = ?";
		try {
			PreparedStatement ps = con.prepareStatement(dml);
			ps.setInt(1, manager_id);
			ps.setInt(2, request_id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Reimbursement> viewRequestsEmp(int user_id) {
		// get all requests.
		List<Reimbursement> list1 = viewResolvedRequests(user_id);
		List<Reimbursement> list2 = viewPendingRequests(user_id);
		list1.addAll(list2);
		return list1;
	}

	@Override
	public List<Reimbursement> viewAllResolvedRequests() {
		List<Reimbursement> all = viewResolvedRequests(0);
		return all;
	}

	@Override
	public List<Reimbursement> viewAllPendingRequests() {
		List<Reimbursement> all = viewPendingRequests(0);
		return all;
	}

}
