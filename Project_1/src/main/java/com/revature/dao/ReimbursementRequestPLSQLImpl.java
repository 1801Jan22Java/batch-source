package com.revature.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.ReimbursementRequest;
import com.revature.util.ConnectionUtil;

public class ReimbursementRequestPLSQLImpl implements ReimbursementRequestDAO {

	@Override
	public void createReimbursementRequest(ReimbursementRequest req) {
		PreparedStatement stmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "INSERT INTO REIMBURSEMENT_REQUEST (AMOUNT, REQ_DATE, EMPL_ID, RECEIPT, DESCRIPTION) "
					+ "VALUES (?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setDouble(1, req.getAmount());
			stmt.setDate(2, Date.valueOf(req.getDateReq()));
			stmt.setInt(3, req.getEmplId());
			stmt.setBlob(4, req.getReceipt());
			stmt.setString(5, req.getDescription());
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ReimbursementRequest getReimbursementRequestById(int id) {
		PreparedStatement stmt = null;
		ReimbursementRequest req = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM REIMBURSEMENT_REQUEST WHERE REQ_ID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String description = rs.getString("DESCRIPTION");
				Blob b = rs.getBlob("RECEIPT");
				double amt = rs.getDouble("AMOUNT");
				Date d = rs.getDate("REQ_DATE");
				int emplId = rs.getInt("EMPL_ID");
				req = new ReimbursementRequest(id, amt, d.toLocalDate(), emplId,
						b, description);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return req;
	}

	@Override
	public void deleteReimbursementRequest(ReimbursementRequest req) {
		PreparedStatement stmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "DELETE FROM REIMBURSEMENT_REQUEST WHERE REQ_ID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, req.getId());
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<ReimbursementRequest> getReimbursementRequests() {
		PreparedStatement stmt = null;
		List<ReimbursementRequest> reqs = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM REIMBURSEMENT_REQUEST WHERE REQ_ID NOT IN (SELECT REQ_ID FROM PROCESSED_REQUESTS)";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("REQ_ID");
				String description = rs.getString("DESCRIPTION");
				Blob b = rs.getBlob("RECEIPT");
				double amt = rs.getDouble("AMOUNT");
				Date d = rs.getDate("REQ_DATE");
				int emplId = rs.getInt("EMPL_ID");
				reqs.add(new ReimbursementRequest(id, amt, d.toLocalDate(),
						emplId, b, description));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reqs;
	}

	@Override
	public List<ReimbursementRequest> getReimbursementRequestsByEmplId(
			int emplId) {
		PreparedStatement stmt = null;
		List<ReimbursementRequest> reqs = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM REIMBURSEMENT_REQUEST WHERE EMPL_ID = ? AND REQ_ID NOT IN (SELECT REQ_ID FROM PROCESSED_REQUESTS)";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, emplId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("REQ_ID");
				String description = rs.getString("DESCRIPTION");
				Blob b = rs.getBlob("RECEIPT");
				double amt = rs.getDouble("AMOUNT");
				Date d = rs.getDate("REQ_DATE");
				emplId = rs.getInt("EMPL_ID");
				reqs.add(new ReimbursementRequest(id, amt, d.toLocalDate(),
						emplId, b, description));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reqs;
	}

	@Override
	public ReimbursementRequest updateReimbursementRequest(
			ReimbursementRequest req) {

		PreparedStatement stmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "UPDATE REIMBURSEMENT_REQUEST SET AMOUNT = ?, RECEIPT = ?, DESCRIPTION = ? "
					+ "WHERE REQ_ID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setDouble(1, req.getAmount());
			stmt.setBlob(2, req.getReceipt());
			stmt.setString(3, req.getDescription());
			stmt.setInt(4, req.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getReimbursementRequestById(req.getEmplId());
	}

}
