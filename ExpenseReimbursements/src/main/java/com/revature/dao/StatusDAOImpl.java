package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Status;
import com.revature.util.ConnectionUtil;

public class StatusDAOImpl implements StatusDAO{

	@Override
	public Status getStatusById(int id) {
		Status statusTitle = new Status();
		try(Connection conn = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM STATUS WHERE STATUS_ID = ?");
			pstmt.setInt(1,  id);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				String statusCode = results.getString("STATUS_CODE");
				statusTitle.setStatusCode(statusCode);
				statusTitle.setStatusId(id);
			};
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return statusTitle;
	}

	@Override
	public List<Status> viewAllStatus() {
		List<Status> allStatus = new ArrayList<Status>();
		try(Connection conn = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM STATUS");
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				String positionName = results.getString("STATUS_CODE");
				int id = results.getInt("STATUS_ID");
				allStatus.add(new Status(id, positionName));
			};
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allStatus;
	}
	
}
