package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.RequestStatus;
import com.revature.util.ConnectionUtil;

public class RequestStatusDaoImpl implements RequestStatusDao {

	@Override
	public List<RequestStatus> getRequestStatuses() {
		List<RequestStatus> requestStatusList = new ArrayList<>();

		PreparedStatement pstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM REQUEST_STATUS";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int requestStatusId = rs.getInt("REQUEST_STATUS_ID");
				String requestStatusName = rs.getString("REQUEST_STATUS_NAME");
				requestStatusList.add(new RequestStatus(requestStatusId, requestStatusName));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return requestStatusList;
	}

	@Override
	public RequestStatus getRequestStatusById(int requestStatusId) {
		PreparedStatement pstmt = null;
		RequestStatus requestStatus = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM REQUEST_STATUS WHERE REQUEST_STATUS_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, requestStatusId);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()){
				String requestStatusName = rs.getString("REQUEST_STATUS_NAME");
				requestStatus = new RequestStatus(requestStatusId, requestStatusName);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return requestStatus;
	}
}
