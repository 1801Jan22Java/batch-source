package com.revature.bdao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bbeans.BankAccount;
import com.revature.bbeans.BankAccount.AccountType;
import com.revature.bbeans.BankUser;
import com.revature.bbeans.BankUserAccount;
import com.revature.butil.*;

public class OrclBankAccountDAO implements IBankAccountDAO {
	
	@Override
	public List<BankAccount> viewAllBankAccounts() {
		ArrayList<BankUserAccount> results = new ArrayList<BankUserAccount>();
		
		try(Connection conn = ConnectionUtil.getConnection("connection.properties")){
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT BANKACCOUNT.USERID, ACCOUNTID, ACCOUNT_TYPE, FIRSTNAME, LASTNAME "
					+ "FROM BANKACCOUNT LEFT JOIN BANKUSER ON BANKACCOUNT.USERID = BANKUSER.USERID");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				results.add(new BankUserAccount(
						new BankUser(rs.getInt(1), rs.getString(5), rs.getString(6)),
						new BankAccount(rs.getInt(2), rs.getInt(1), rs.getDouble(3), AccountType.valueOf(rs.getString(4)))));
			}
			
			PlainConsoleFormatter.printAccountInfo(results);
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
		return null;
	}

	@Override
	public List<BankAccount> viewAllBankAccounts(int userID) {
		ArrayList<BankUserAccount> results = new ArrayList<BankUserAccount>();
		
		try(Connection conn = ConnectionUtil.getConnection("connection.properties")){
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT BANKACCOUNT.USERID, ACCOUNTID, BALANCE, ACCOUNT_TYPE, FIRSTNAME, LASTNAME "
					+ "FROM BANKACCOUNT LEFT JOIN BANKUSER ON BANKACCOUNT.USERID = BANKUSER.USERID "
					+ "WHERE BANKACCOUNT.USERID = ?");
			pstmt.setInt(1, userID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				results.add(new BankUserAccount(
						new BankUser(rs.getInt(1), rs.getString(5), rs.getString(6)),
						new BankAccount(rs.getInt(2), rs.getInt(1), rs.getDouble(3), AccountType.valueOf(rs.getString(4)))));
			}
			
			PlainConsoleFormatter.printAccountInfo(results);
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
		return null;
	}
	
	@Override
	public List<BankAccount> viewBankAccountType(BankAccount.AccountType at) {
		List<BankUserAccount> results = new ArrayList<BankUserAccount>();
		
		try(Connection conn = ConnectionUtil.getConnection("connection.properties")){
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT BANKACCOUNT.USERID, ACCOUNTID, BALANCE, ACCOUNT_TYPE, FIRSTNAME, LASTNAME "
					+ "FROM BANKACCOUNT LEFT JOIN BANKUSER ON BANKACCOUNT.USERID = BANKUSER.USERID "
					+ "WHERE ACCOUNT_TYPE=?");
			pstmt.setString(1, at.toString());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				results.add(new BankUserAccount(
						new BankUser(rs.getInt(1), rs.getString(5), rs.getString(6)),
						new BankAccount(rs.getInt(2), rs.getInt(1), rs.getDouble(3), at)));
			}
			
			PlainConsoleFormatter.printAccountInfo(results);
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
		return null;
	}

	@Override
	public List<BankAccount> viewBankAccountType(int userID, BankAccount.AccountType at) {
		List<BankUserAccount> results = new ArrayList<BankUserAccount>();
		
		try(Connection conn = ConnectionUtil.getConnection("connection.properties")){
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT BANKACCOUNT.USERID, ACCOUNTID, BALANCE, ACCOUNT_TYPE, FIRSTNAME, LASTNAME "
					+ "FROM BANKACCOUNT LEFT JOIN BANKUSER ON BANKACCOUNT.USERID = BANKUSER.USERID "
					+ "WHERE BANKACCOUNT.USERID = ? AND ACCOUNT_TYPE=?");
			pstmt.setInt(1, userID);
			pstmt.setString(2, at.toString());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				results.add(new BankUserAccount(
						new BankUser(rs.getInt(1), rs.getString(5), rs.getString(6)),
						new BankAccount(rs.getInt(2), rs.getInt(1), rs.getDouble(3), at)));
			}
			
			PlainConsoleFormatter.printAccountInfo(results);
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
		return null;
	}
	
	@Override
	public void deleteBankAccount(int userID, BankAccount.AccountType at) {
		try(Connection conn = ConnectionUtil.getConnection("connection.properties")){
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM BANKACCOUNT WHERE USERID=? AND ACCOUNT_TYPE=?");
			pstmt.setInt(1, userID);
			pstmt.setString(2, at.toString());
			pstmt.execute();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}

	}

	@Override
	public void deleteBankAccount(int accountID) {
		try(Connection conn = ConnectionUtil.getConnection("connection.properties")){
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM BANKACCOUNT WHERE ACCOUNTID=?");
			pstmt.setInt(1, accountID);
			pstmt.execute();
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
	}
	
	@Override
	public void createBankAccount(int userID, double initialDeposit, BankAccount.AccountType at) {
		try(Connection conn = ConnectionUtil.getConnection("connection.properties")){
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO BANKACCOUNT(ACCOUNTID, USERID, BALANCE, ACCOUNT_TYPE)"
					+ " VALUES(1,?,?,?)");
			pstmt.setInt(1, userID);
			pstmt.setDouble(2, initialDeposit);
			pstmt.setString(3, at.toString());
			pstmt.execute();
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}

	}

	@Override
	public int depositFunds(int userID, BankAccount.AccountType at, double deposit) {
		try(Connection conn = ConnectionUtil.getConnection("connection.properties")){
			
			CallableStatement cstmt = conn.prepareCall("call deposit_funds(?,?,?)");
			cstmt.setDouble(1, deposit);
			cstmt.setInt(2, userID);
			cstmt.setString(3, at.toString());
			cstmt.execute();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
		return 0;
	}

	@Override
	public int withdrawFunds(int userID, BankAccount.AccountType at, double withdrawal) {
			try(Connection conn = ConnectionUtil.getConnection("connection.properties")){
			
			CallableStatement cstmt = conn.prepareCall("call withdraw_funds(?,?,?)");
			cstmt.setDouble(1, withdrawal);
			cstmt.setInt(2, userID);
			cstmt.setString(3, at.toString());
			cstmt.execute();
			
		}catch(SQLException e) {
			
			PlainConsoleFormatter.printError("Account overdraw not acceptable.");
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}

		return 0;
	}

	@Override
	public void transferFunds(int userID, BankAccount.AccountType at1, BankAccount.AccountType at2, double transferAmount) {
		// TODO Auto-generated method stub
		/* Have a stored procedure that takes in two account types and a transfer amount as parameters,
		 * create error handling on the existence of both accounts, rely on trigger to take care of overdraws,
		 * use two update statements to handle movement of cash.
		 */
	}

}
