package com.revature.bdao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bbeans.BankUser;
import com.revature.butil.ConnectionUtil;
import com.revature.butil.PlainConsoleFormatter;

public class OrclBankUserDAO implements IBankUserDAO {
	
	public BankUser userInDatabase(String username, String password) {
		String first = "", last = "";
		int userid = 0;
		
		try(Connection conn = ConnectionUtil.getConnection("connection.properties")){
			
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT * FROM BANKUSER WHERE USERNAME = ? AND PASSWORD = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				first =     rs.getString("FIRSTNAME");
				last =      rs.getString("LASTNAME");
				userid =    rs.getInt("USERID");
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			return new BankUser();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
		return new BankUser(userid, first, last, username, password);
	}
	
	@Override
	public BankUser addBankUser(String first, String last, String username, String password) {
			try(Connection conn = ConnectionUtil.getConnection("connection.properties")){
			
			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO BANKUSER(USERID, FIRSTNAME, LASTNAME, USERNAME, PASSWORD) "
					+ "VALUES(1,?,?,?,?)");
			pstmt.setString(1, first);
			pstmt.setString(2, last);
			pstmt.setString(3, username);
			pstmt.setString(4, password);
			pstmt.execute();
			
			PreparedStatement pstmt2 = conn.prepareStatement("SELECT USERID WHERE USERNAME = ? AND PASSWORD = ?");
			pstmt2.setString(1, username);
			pstmt2.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			int userID = 0;
			while(rs.next()) {
				userID = rs.getInt("USERID");
			}
			
			return new BankUser(userID, first, last, username, password);
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
		return new BankUser();
	}

	@Override
	public void removeBankUser(int userID) {
		try(Connection conn = ConnectionUtil.getConnection("connection.properties")){
			
		PreparedStatement pstmt1 = conn.prepareStatement(
				"UPDATE BANKACCOUNT SET BALANCE = 0 WHERE USERID = ?");
		pstmt1.setInt(1, userID);
		pstmt1.execute();
			
		PreparedStatement pstmt2 = conn.prepareStatement(
				"DELETE FROM BANKACCOUNT WHERE USERID = ?");
		pstmt2.setInt(1, userID);
		pstmt2.execute();
		
		PreparedStatement pstmt3 = conn.prepareStatement(
				"DELETE FROM BANKUSER WHERE USERID = ?");
		pstmt3.setInt(1, userID);
		pstmt3.execute();
		
	}catch(SQLException e) {
		
		e.printStackTrace();
		
	}catch(IOException e) {
		
		e.printStackTrace();
		
	}

	}

	@Override
	public List<BankUser> viewAllBankUsers() {
		List<BankUser> bUsers = new ArrayList<BankUser>();
		
		try(Connection conn = ConnectionUtil.getConnection("connection.properties")){
			
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT * FROM BANKUSER");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bUsers.add(new BankUser(rs.getInt("USERID"), rs.getString("FIRSTNAME"), 
						rs.getString("LASTNAME"), rs.getString("USERNAME"), rs.getString("PASSWORD")));
			}
			
			PlainConsoleFormatter.printUserInfo(bUsers);
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public BankUser viewBankUser(int userID) {
			try(Connection conn = ConnectionUtil.getConnection("connection.properties")){
			
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT * FROM BANKUSER WHERE USERID = ?");
			pstmt.setInt(1, userID);
			ResultSet rs = pstmt.executeQuery();
			
			BankUser bUser = new BankUser(rs.getInt("USERID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("USERNAME"), rs.getString("PASSWORD"));
			
			PlainConsoleFormatter.printUserInfo(bUser);
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		return null;
	}

	
	@Override
	public void updateAccountPassword(int userID, String newPassword) {
			try(Connection conn = ConnectionUtil.getConnection("connection.properties")){
			
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE BANK USER SET PASSWORD = ? WHERE USERID = ?");
			pstmt.setString(1, newPassword);
			pstmt.setInt(2, userID);
			pstmt.execute();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}

	}

}
