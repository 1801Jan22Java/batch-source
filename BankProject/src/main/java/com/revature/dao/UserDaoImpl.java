package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Checkings;
import com.revature.beans.Savings;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	private static String filename = "connection.properties";
	
	public ArrayList<User> getUsers() {
		
		ArrayList<User> users = new ArrayList<User>();
		
		PreparedStatement pstmt = null;
		CheckingsDaoImpl cdi = new CheckingsDaoImpl();
		SavingsDaoImpl sdi = new SavingsDaoImpl();

		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){

			String sql = "SELECT USERS.*, CHECKINGS_BALANCE, SAVINGS_BALANCE "
					+ "FROM USERS INNER JOIN SAVINGS ON USERS.USER_ID = SAVINGS.USER_ID "
				    + "INNER JOIN CHECKINGS ON CHECKINGS.USER_ID = SAVINGS.USER_ID AND "
				    + "CHECKINGS.USER_ID = SAVINGS.USER_ID";

			pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery(sql);

			while (rs.next()){

				int userId = rs.getInt("USER_ID");
				String username = rs.getString("USER_USERNAME");
				String password = rs.getString("USER_PASSWORD");
				
				Checkings checkings = cdi.getCheckingsByUserId(userId);
				Savings savings = sdi.getSavingsByUserId(userId);

				//(int userId, String username, String password, 
				//double checkingsBalance, double savingsBalance)
				users.add(new User(userId, username, password, 
						checkings.getCheckingsBalance(), savings.getSavingsBalance()));
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return users;
	}

	public User getUserById(int id) {
		return null;
	}

	@Override
	public void insertNewUser(String username, String password) {
		
		PreparedStatement pstmt = null;

		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){

			String sql = "INSERT INTO USERS (USER_USERNAME, USER_PASSWORD) VALUES (?, ?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,username);
			pstmt.setString(2,password);
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
