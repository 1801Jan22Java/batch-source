package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public class SuperUserDAOImpl implements SuperUserDAO {

	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void createNewUser(User u) {
		// TODO Auto-generated method stub
		
	}

	public void updateUserById(int id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}


	public User getUserById(int id) {
		User newUser = new User();
//		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename)){
//			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USER WHERE USERID = ?");
//			pstmt.setInt(1, id);
//			ResultSet results = pstmt.executeQuery();
//			if(results.next()) {
//				String username = results.getString("USERNAME");
//				newUser.setId = id;
//				newUser.setUsername = username;
//			}
//			conn.close();
//		}
		return newUser;
	}

	public User getUserByUsername(String username) {
		User newUser = new User();
//		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename)){
//			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USER WHERE USERNAME = ?");
//			pstmt.setInt(1, id);
//			ResultSet results = pstmt.executeQuery();
//			if(results.next()) {
//				int id = results.getString("USERID");
//				newUser.setId = id;
//				newUser.setUsername = username;
//			}
//			conn.close();
//		}
		return newUser;
	}

	public boolean checkCredentials(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
