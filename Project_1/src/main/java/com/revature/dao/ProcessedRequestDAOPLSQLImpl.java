package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.ProcessedRequest;
import com.revature.beans.RequestStatus;
import com.revature.util.ConnectionUtil;

public class ProcessedRequestDAOPLSQLImpl implements ProcessedRequestDAO {

	@Override
	public ProcessedRequest getProcessedRequestById(int id) {
		PreparedStatement stmt = null;
		ProcessedRequest pr = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM PROCESSED_REQUESTS WHERE PR_ID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int reqId = rs.getInt("REQ_ID");
				int mId = rs.getInt("MANAGER_ID");
				Date d = rs.getDate("PROCESSED_ON");
				String status = rs.getString("STATUS");
				RequestStatus s;
				if (status.equals("APPROVED")) {
					s = RequestStatus.APPROVED;
				} else {
					s = RequestStatus.DENIED;
				}
				pr = new ProcessedRequest(id, reqId, s, mId, d.toLocalDate());
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pr;
	}

	@Override
	public void createProcessedRequest(ProcessedRequest pr) {

		PreparedStatement stmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "INSERT INTO PROCESSED_REQUESTS (REQ_ID, MANAGER_ID, PROCESSED_ON, STATUS) "
					+ "VALUES (?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, pr.getReqId());
			stmt.setInt(2, pr.getManagerId());
			stmt.setDate(3, Date.valueOf(pr.getDatePro()));
			stmt.setString(4, pr.getStatus().toString());
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
	public List<ProcessedRequest> getProcessedRequests() {
		PreparedStatement stmt = null;
		List<ProcessedRequest> prs = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM PROCESSED_REQUESTS";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("PR_ID");
				int reqId = rs.getInt("REQ_ID");
				int mId = rs.getInt("MANAGER_ID");
				Date d = rs.getDate("PROCESSED_ON");
				String status = rs.getString("STATUS");
				RequestStatus s;
				if (status.equals("APPROVED")) {
					s = RequestStatus.APPROVED;
				} else {
					s = RequestStatus.DENIED;
				}
				prs.add(new ProcessedRequest(id, reqId, s, mId,
						d.toLocalDate()));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prs;
	}

	@Override
	public ProcessedRequest updateProcessedRequest(ProcessedRequest pr) {
		PreparedStatement stmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "UPDATE PROCESSED_REQUESTS SET STATUS = ? "
					+ "WHERE PR_ID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, pr.getStatus().toString());
			stmt.setInt(2, pr.getId());
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getProcessedRequestById(pr.getId());
	}

	@Override
	public void deleteProcessedRequest(ProcessedRequest pr) {

		PreparedStatement stmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "DELETE FROM PROCESSED_REQUESTS " + "WHERE PR_ID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, pr.getId());
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

}
