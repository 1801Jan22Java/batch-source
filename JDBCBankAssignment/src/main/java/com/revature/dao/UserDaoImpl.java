package com.revature.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	public User login(String username, String password) {

		try {
			String sql = "SELECT * FROM BANK_USERS WHERE USERNAME=? AND USERPASS=?";
			PreparedStatement statement = ConnectionUtil.connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String user = rs.getString(2);
				String pass = rs.getString(3);
				return new User(id, user, pass);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	public User register(String username, String password) {

		try {
			String sql = "INSERT INTO BANK_USERS VALUES(USER_SEQUENCE.NEXTVAL,?,?)";
			PreparedStatement statement = ConnectionUtil.connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.executeQuery();
			System.out.println("Account created! You may now log in!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
