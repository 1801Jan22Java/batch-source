package com.revature.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;
import com.revature.util.UsernameTakenException;

public class UserDaoImpl implements UserDao {

	//Logs in a user from a given username and password
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
				
				//Check to see if this guy is a super user
				String sql2 = "SELECT * FROM BANK_SUPERUSERS WHERE USERID=?";
				PreparedStatement statement2 = ConnectionUtil.connection.prepareStatement(sql2);
				statement2.setInt(1, id);
				ResultSet rs2 = statement2.executeQuery();
				
				//If userID is found in the super user table they are a super user
				boolean isSuperUser = false;
				if(rs2.next()) isSuperUser = true;
				
				return new User(id, user, pass, isSuperUser);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	//Check to see if someone has this username, this includes nullified passwords
	public boolean isUsernameTaken(String name) throws UsernameTakenException{
		
		try {
			String sql = "SELECT * FROM BANK_USERS WHERE USERNAME=?";
			PreparedStatement statement = ConnectionUtil.connection.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				throw new UsernameTakenException();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//Registers a new user
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

	//Gets every user except the "deleted" ones
	public List<User> getAllUsers() {

		List<User> users = new ArrayList<User>();
		
		try {
			//If password is null, the user has been "deleted"
		String sql = "SELECT * FROM BANK_USERS WHERE USERPASS IS NOT NULL";
		PreparedStatement statement = ConnectionUtil.connection.prepareStatement(sql);

		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt(1);
			String user = rs.getString(2);
			String pass = rs.getString(3);
			
			//Being a super user here doesn't really matter
			users.add(new User(id, user, pass, false));
		}
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	//changes a user's username and/or password
	public void updateUser(User user, String username, String password) {

		try {
			String sql = "UPDATE BANK_USERS SET USERNAME=?, USERPASS=? WHERE USERID=?";
			PreparedStatement statement = ConnectionUtil.connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setInt(3, user.getId());
			statement.executeQuery();
			System.out.println("Account Updated!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	//Deletes (nullifies) a user
	public void deleteUser(User user) {
		try {
			String sql = "UPDATE BANK_USERS SET USERPASS=NULL WHERE USERID=?";
			PreparedStatement statement = ConnectionUtil.connection.prepareStatement(sql);
			statement.setInt(1, user.getId());
			statement.executeQuery();
			System.out.println("Account Deleted!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
