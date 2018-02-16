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

public class UserDAOImpl implements UserDAO{

	@Override
	public User checkCredentials(String username, String password) {
		User currentUser = new User();
		try(Connection conn = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement pstmt = conn.prepareStatement("SELECT  * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet results = pstmt.executeQuery();
			while(results.next()) {
				String firstName = results.getString("FIRST_NAME");
				String lastName = results.getString("LAST_NAME");
				String email = results.getString("EMAIL");
				int position_id = results.getInt("POSITION");
				int user_id = results.getInt("USER_ID");
				currentUser.setUserId(user_id);
				currentUser.setFirstName(firstName);
				currentUser.setLastName(lastName);
				currentUser.setEmail(email);
				currentUser.setUserName(username);
				currentUser.setPassword(password);
				currentUser.setPosition_id(position_id);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentUser;
	}

	@Override
	public User getUserById(int id) {
		User foundUser = new User();
		try(Connection conn = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USERS WHERE USER_ID = ?");
			pstmt.setInt(1, id);
			ResultSet results = pstmt.executeQuery();
			while(results.next()) {
				String firstName = results.getString("FIRST_NAME");
				String lastName = results.getString("LAST_NAME");
				String email = results.getString("EMAIL");
				int position_id = results.getInt("POSITION");
				String username = results.getString("USERNAME");
				foundUser.setEmail(email);
				foundUser.setFirstName(firstName);
				foundUser.setLastName(lastName);
				foundUser.setPosition_id(position_id);
				foundUser.setUserName(username);
				foundUser.setUserId(id);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foundUser;
	}

	@Override
	public User getUserByUsername(String username) {
		User foundUser = new User();
		try(Connection conn = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ?");
			pstmt.setString(1, username);
			ResultSet results = pstmt.executeQuery();
			while(results.next()) {
				String firstName = results.getString("FIRST_NAME");
				String lastName = results.getString("LAST_NAME");
				String email = results.getString("EMAIL");
				int position_id = results.getInt("POSITION");
				int user_id = results.getInt("USER_ID");
				foundUser.setEmail(email);
				foundUser.setFirstName(firstName);
				foundUser.setLastName(lastName);
				foundUser.setPosition_id(position_id);
				foundUser.setUserId(user_id);
				foundUser.setUserName(username);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foundUser;
	}

	@Override
	public List<User> viewAllUsers() {
		List<User> allUsers = new ArrayList<User>();
		try(Connection conn = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USERS");
			ResultSet results = pstmt.executeQuery();
			while(results.next()) {
				String firstName = results.getString("FIRST_NAME");
				String lastName = results.getString("LAST_NAME");
				String email = results.getString("EMAIL");
				String username = results.getString("USERNAME");
				String password = results.getString("PASSWORD");
				int position_id = results.getInt("POSITION");
				int user_id = results.getInt("USER_ID");
				allUsers.add(new User(user_id, firstName,lastName,username,password,email,position_id));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allUsers;
	}

	@Override
	public void updatePersonalInfo(User employee, String column, String value) {
		try(Connection conn = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement pstmt = null;
			switch(column) {
			case "firstname":
				pstmt = conn.prepareStatement("UPDATE USERS SET FIRST_NAME = ? WHERE USER_ID = ?");
				break;
			case "lastname":
				pstmt = conn.prepareStatement("UPDATE USERS SET LAST_NAME = ? WHERE USER_ID = ?");
				break;
			case "email":
				pstmt = conn.prepareStatement("UPDATE USERS SET EMAIL = ? WHERE USER_ID = ?");
				break;
			case "password":
				pstmt = conn.prepareStatement("UPDATE USERS SET PASSWORD = ? WHERE USER_ID = ?");
				break;
			default:
				break;
			}
			pstmt.setString(1, value);
			pstmt.setInt(2, employee.getUserId());
			pstmt.executeUpdate();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
