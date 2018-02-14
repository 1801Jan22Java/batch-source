package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserOracle implements UserDAO {

	// Instantiate connection once.
	Connection con;
	private String filename = "connection.properties";

	// Connection
	public UserOracle() {
		try {
			con = ConnectionUtil.getConnectionFromFile(this.filename);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUser(String username, String password) {
		String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
		User user = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int user_id = rs.getInt("USER_ID");
				String uname = rs.getString("USERNAME");
				String pword = rs.getString("PASSWORD");
				String first_name = rs.getString("FIRST_NAME");
				String last_name = rs.getString("LAST_NAME");
				int position_id = rs.getInt("POSITION_ID");
				user = new User(user_id, uname, first_name, last_name, pword, position_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public boolean editInfo(int user_id, String firstname, String lastname, String password) {
		String dml = "UPDATE USERS SET FIRST_NAME = ?, LAST_NAME = ?, PASSWORD = ? WHERE USER_ID = ?";
		try {
			PreparedStatement ps = con.prepareStatement(dml);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, password);
			ps.setInt(4, user_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	@Override
	public List<User> getAllEmployees() {
		String sql = "SELECT * FROM USERS";
		List<User> users = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int user_id = rs.getInt("USER_ID");
				String uname = rs.getString("USERNAME");
				String pword = rs.getString("PASSWORD");
				String first_name = rs.getString("FIRST_NAME");
				String last_name = rs.getString("LAST_NAME");
				int position_id = rs.getInt("POSITION_ID");
				users.add(new User(user_id, uname, first_name, last_name, pword, position_id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

}
