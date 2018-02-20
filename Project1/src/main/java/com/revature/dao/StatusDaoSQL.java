package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class StatusDaoSQL implements StatusDao {

	@Override
	public String getStatusById(int statusId) {
		String status = "";
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT STATUS_CODE FROM STATUS WHERE STATUS_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, statusId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				status = rs.getString("STATUS_CODE");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}

}
