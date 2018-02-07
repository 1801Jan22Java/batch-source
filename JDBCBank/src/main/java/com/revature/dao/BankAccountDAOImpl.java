package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.User;
import com.revature.exceptions.BalanceNotEmptyException;
import com.revature.exceptions.OverdraftException;
import com.revature.util.ConnectionUtil;

public class BankAccountDAOImpl implements BankAccountDAO{
	
	private static String filename = "connection.properties";

	public void createAccount(String accountType, User user) {
		Connection conn;
		try{
			conn = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO BANKACCOUNTS (BANK_ACCOUNT_ID, ACCOUNT_TYPE, BALANCE, USER_ID) VALUES (BANK_ACCOUNT_ID_SEQ.NEXTVAL, ?, ?, ?)");
			pstmt.setString(1, accountType);
			pstmt.setInt(2, 0);
			pstmt.setInt(3, user.getId());
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteAccountById(int id, User user) {
		Connection conn;
		try{
			conn = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement pstmt = conn.prepareStatement("SELECT BALANCE FROM BANKACCOUNTS WHERE BANK_ACCOUNT_ID = ?");
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				try {
					if(rs.getDouble("BALANCE") == 0) {
						CallableStatement cstmt = conn.prepareCall("{call DELETEBANKACCOUNT(?, ?)}");
						cstmt.setInt(1, id);
						cstmt.setInt(2, user.getId());
						cstmt.execute();
					} else {
						throw new BalanceNotEmptyException("The account is not empty");
					}
				} catch (BalanceNotEmptyException e) {
					System.out.println(e.getMessage());
				}
			}
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void depositMoneyToAccount(int accountID, double money, User user) {
		BankAccount getInfo = this.viewBankAccountByID(accountID, user);
		Connection conn;
		try{
			conn = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement pstmt = conn.prepareStatement("UPDATE BANKACCOUNTS SET BALANCE = ? WHERE USER_ID = ? AND BANK_ACCOUNT_ID = ?");
			pstmt.setDouble(1, getInfo.getbalance() + money);
			pstmt.setInt(2, user.getId());
			pstmt.setInt(3,  accountID);
			System.out.println("Updating bank account");
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void withdrawMoneyFromAccount(int accountID, double money, User user) throws OverdraftException{
		BankAccount getInfo = this.viewBankAccountByID(accountID, user);
		Connection conn;
		try{
			conn = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement checkAccount = conn.prepareStatement("SELECT BALANCE FROM BANKACCOUNTS WHERE BANK_ACCOUNT_ID = ?");
			checkAccount.setInt(1, accountID);
			ResultSet rs = checkAccount.executeQuery();
			while(rs.next()) {
				if(rs.getDouble("BALANCE") < money) {
					throw new OverdraftException("You do not have that much money");
				}
			}
			PreparedStatement pstmt = conn.prepareStatement("UPDATE BANKACCOUNTS SET BALANCE = ? WHERE USER_ID = ? AND BANK_ACCOUNT_ID = ?");
			pstmt.setDouble(1, getInfo.getbalance() - money);
			pstmt.setInt(2, user.getId());
			pstmt.setInt(3,  accountID);
			System.out.println("Updating bank account");
			pstmt.executeUpdate();
			conn.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<BankAccount> viewBankAccounts(User user) {
		List<BankAccount> userAccounts = new ArrayList<BankAccount>();
		Connection conn;
		try{
			conn = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement pstmt = conn.prepareStatement("SELECT BANK_ACCOUNT_ID, BALANCE, ACCOUNT_TYPE FROM BANKACCOUNTS WHERE BANKACCOUNTS.USER_ID = ?");
			pstmt.setInt(1, user.getId());
			ResultSet results = pstmt.executeQuery();
			while(results.next()) {
				int id = results.getInt("BANK_ACCOUNT_ID");
				double balance = results.getDouble("BALANCE");
				String accountType = results.getString("ACCOUNT_TYPE");
				userAccounts.add(new BankAccount(id, balance, user, accountType));
			}
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userAccounts;
	}

	public BankAccount viewBankAccountByID(int accountID, User currentUser) {
		BankAccount currentUserAccount = new BankAccount();
		Connection conn;
		try{
			conn = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM BANKACCOUNTS WHERE BANK_ACCOUNT_ID = ?");
			pstmt.setInt(1, accountID);
			ResultSet results = pstmt.executeQuery();
			while(results.next()) {
				String accountType = results.getString("ACCOUNT_TYPE");
				double balance = results.getDouble("BALANCE");
				currentUserAccount.setAccountType(accountType);
				currentUserAccount.setbalance(balance);
				currentUserAccount.setUser(currentUser);
				currentUserAccount.setId(accountID);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return currentUserAccount;
	}


}
