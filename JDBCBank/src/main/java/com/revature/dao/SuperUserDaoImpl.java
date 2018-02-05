package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.revature.beans.User;

public class SuperUserDaoImpl extends UserDaoImpl implements SuperUserDao {

	public void viewUsers(User user) throws Exception {
		// selects and displays all fields from Users table
		String sql = "SELECT UserID, UserName, Password FROM Users";
		PreparedStatement pstmt = user.getConn().prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.println("UserID: " + rs.getInt("UserID") + " UserName: " + rs.getString("UserName")
					+ " Password: " + rs.getString("Password"));
		}
	}

	public void updateUser(User user, int userID, String username, String password) throws Exception {
		// updates the UserName and Password for the user with the specified UserID
		CallableStatement cstmt = user.getConn().prepareCall("{CALL update_user(?,?,?)}");
		cstmt.setInt(1, userID);
		cstmt.setString(2, username);
		cstmt.setString(3, password);
		cstmt.execute();
	}

	public void deleteUser(User user, int userID) throws Exception {
		// deletes the user with the specified UserID
		CallableStatement cstmt = user.getConn().prepareCall("{CALL delete_user(?)}");
		cstmt.setInt(1, userID);
		cstmt.execute();
	}

}
