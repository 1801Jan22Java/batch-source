package com.revature.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.PhantomReference;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import com.revature.beans.Image;
import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimburseOracle implements ReimburseDAO {
	// Instantiate connection once.
	Connection con;
	private String filename = "connection.properties";

	// Connection
	public ReimburseOracle() {

	}

	@Override
	public List<Reimbursement> viewPendingRequests(int user_id) {
		String sql = "";
		if (user_id == 0) {
			sql = "SELECT * FROM REIMBURSE_REQUEST WHERE REIMBURSE_STATUS_ID = 1 ORDER BY REIMBURSE_REQUEST_ID ASC";
		} else {
			sql = "SELECT * FROM REIMBURSE_REQUEST WHERE USER_ID = ? AND REIMBURSE_STATUS_ID = 1 REIMBURSE_REQUEST_ID ASC";
		}
		List<Reimbursement> reim = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile(this.filename)) {

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
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return reim;
	}

	@Override
	public List<Reimbursement> viewPendingRequests(String username) {
		String sql = "";

		sql = "SELECT * " + "FROM REIMBURSE_REQUEST, USERS "
				+ "WHERE USERS.USERNAME = ? AND REIMBURSE_STATUS_ID = 1 AND USERS.USER_ID = REIMBURSE_REQUEST.USER_ID ORDER BY REIMBURSE_REQUEST ASC";
		List<Reimbursement> reim = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile(this.filename)) {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
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
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return reim;
	}

	@Override
	public List<Reimbursement> viewResolvedRequests(int user_id) {
		String sql = "";
		if (user_id == 0) {
			sql = "SELECT * FROM REIMBURSE_REQUEST WHERE REIMBURSE_STATUS_ID > 1 ORDER BY REIMBURSE_REQUEST ASC";
		} else {
			sql = "SELECT * FROM REIMBURSE_REQUEST WHERE USER_ID = ? AND REIMBURSE_STATUS_ID > 1 ORDER BY REIMBURSE_REQUEST ASC";
		}

		List<Reimbursement> reim = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile(this.filename)) {
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
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return reim;
	}

	// private double getAmount(int request_id) {
	// String sql = "SELECT AMOUNT FROM REIMBURSE_REQUEST WHERE
	// REIMBURSE_REQUEST_ID=?";
	// try {
	// PreparedStatement ps = con.prepareStatement(sql);
	// ResultSet rs = ps.executeQuery();
	// ps.setInt(1, request_id);
	// while (rs.next()) {
	// return rs.getDouble("AMOUNT");
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return 0.0;
	// }

	@Override
	public boolean reimburseRequest(int user_id, double amount, String notes) {
		String dml = "INSERT INTO REIMBURSE_REQUEST (USER_ID, AMOUNT, NOTES) VALUES (?,?,?)";
		try (Connection con = ConnectionUtil.getConnectionFromFile(this.filename)) {
			PreparedStatement ps = con.prepareStatement(dml);
			ps.setInt(1, user_id);
			ps.setDouble(2, amount);
			ps.setString(3, notes);
			ps.executeUpdate();
			return true;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean uploadImage(int request_id, InputStream is) {
		String dml = "UPDATE REIMBURSE_REQUEST SET PHOTO_BLOB = ? WHERE REIMBURSE_REQUEST_ID = "
				+ "(SELECT MAX(REIMBURSE_REQUEST_ID) FROM REIMBURSE_REQUEST)";
		try (Connection con = ConnectionUtil.getConnectionFromFile(this.filename)) {
			PreparedStatement ps = con.prepareStatement(dml);
			ps.setBlob(1, is);
			ps.executeUpdate();
			return true;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Still implementing
	@Override
	public ByteArrayOutputStream viewImage(int request_id) {
		String dml = "SELECT PHOTO_BLOB FROM REIMBURSE_REQUEST WHERE REIMBURSE_REQUEST_ID = ?";
		OutputStream os = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(this.filename)) {
			PreparedStatement ps = con.prepareStatement(dml);

			ps.setInt(1, request_id);
			ResultSet rs = ps.executeQuery();

			Blob blob = null;
			while (rs.next()) {
				blob = rs.getBlob("PHOTO_BLOB");
			}

			if (blob != null) {
				InputStream in = blob.getBinaryStream();
				ByteArrayOutputStream out = new ByteArrayOutputStream();

				int length = (int) blob.length();

				int bufferSize = 1024;
				byte[] buffer = new byte[bufferSize];
				
				while((length = in.read(buffer))!=-1) {
					out.write(buffer, 0, length);
				}
				return out;
			}

			return null;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Image> getAllImages() {
		String dml = "SELECT REIMBURSE_REQUEST_ID, PHOTO_BLOB FROM REIMBURSE_REQUEST WHERE PHOTO_BLOB IS NOT NULL";
		OutputStream os = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(this.filename)) {
			PreparedStatement ps = con.prepareStatement(dml);

			ResultSet rs = ps.executeQuery();

			List<Image> images = new ArrayList<>();

			while (rs.next()) {
				InputStream is = rs.getBinaryStream("PHOTO_BLOB");
				int request_id = rs.getInt("REIMBURSE_REQUEST_ID");
				images.add(new Image(is, request_id));
			}
			return images;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean approveRequest(int request_id, double amount, int manager_id) {
		if (amount < 0.0) {
			return false;
		}
		String dml = "UPDATE REIMBURSE_REQUEST SET REIMBURSE_STATUS_ID = 3, AMOUNT_APPROVED = ?, RESOLVED_BY = ? WHERE REIMBURSE_REQUEST_ID = ?";
		try (Connection con = ConnectionUtil.getConnectionFromFile(this.filename)) {
			PreparedStatement ps = con.prepareStatement(dml);
			ps.setDouble(1, amount);
			ps.setInt(2, manager_id);
			ps.setInt(3, request_id);
			ps.executeUpdate();
			return true;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean approveRequest(int request_id, int manager_id) {

		String dml = "UPDATE REIMBURSE_REQUEST SET REIMBURSE_STATUS_ID = 3,  RESOLVED_BY = ? WHERE REIMBURSE_REQUEST_ID = ?";
		try (Connection con = ConnectionUtil.getConnectionFromFile(this.filename)) {
			PreparedStatement ps = con.prepareStatement(dml);
			ps.setInt(1, manager_id);
			ps.setInt(2, request_id);
			ps.executeUpdate();
			return true;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean denyRequest(int request_id, int manager_id) {
		String dml = "UPDATE REIMBURSE_REQUEST SET REIMBURSE_STATUS_ID = 2, RESOLVED_BY = ? WHERE REIMBURSE_REQUEST_ID = ?";
		try (Connection con = ConnectionUtil.getConnectionFromFile(this.filename)) {
			PreparedStatement ps = con.prepareStatement(dml);
			ps.setInt(1, manager_id);
			ps.setInt(2, request_id);
			ps.executeUpdate();
			return true;
		} catch (SQLException | IOException e) {
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
	public List<Reimbursement> viewAllRequestsEmp(String username) {
		String sql = "SELECT * " + "FROM REIMBURSE_REQUEST, USERS "
				+ "WHERE USERS.USERNAME = ? AND USERS.USER_ID = REIMBURSE_REQUEST.USER_ID "
				+ "ORDER BY REIMBURSE_REQUEST_ID ASC";
		PreparedStatement ps = null;
		List<Reimbursement> reim = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile(this.filename)) {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
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
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return reim;
	}

	public List<Reimbursement> viewAllRequests() {
		String sql = "SELECT * FROM REIMBURSE_REQUEST ORDER BY REIMBURSE_REQUEST_ID ASC";
		PreparedStatement ps = null;
		List<Reimbursement> reim = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile(this.filename)) {
			ps = con.prepareStatement(sql);
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
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return reim;
	}

}
