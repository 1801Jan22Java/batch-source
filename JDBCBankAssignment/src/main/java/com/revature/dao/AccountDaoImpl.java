package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;
import com.revature.util.OverdraftException;

public class AccountDaoImpl implements AccountDao{

	//Get all the bank accounts associated with a user
	public List<Account> getAccounts(User owner) {

		List<Account> accounts = new ArrayList<Account>();
		
		try {
			String sql = "SELECT * FROM BANK_ACCOUNT "+ 
					"INNER JOIN BANK_USERACCOUNTS " + 
					"ON BANK_ACCOUNT.ACCOUNTID=BANK_USERACCOUNTS.ACCOUNTID " + 
					"WHERE BANK_USERACCOUNTS.USERID = ?";
			
			PreparedStatement statement = ConnectionUtil.connection.prepareStatement(sql);
			statement.setInt(1, owner.getId());
			ResultSet rs = statement.executeQuery();
			
			//Add each resulting account to the accounts list before return the list
			while(rs.next()) {
				int accountID = rs.getInt(1);
				String accountName = rs.getString(2);
				float accountValue = rs.getFloat(3);
				
				accounts.add(new Account(accountID, accountName, accountValue));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}

	//Creates a new account
	public void createAccount(User owner, String accountName) {

		try {
			String sql = "INSERT INTO BANK_ACCOUNT VALUES(ACCOUNT_SEQUENCE.NEXTVAL,?,0)";
			PreparedStatement statement = ConnectionUtil.connection.prepareStatement(sql);
			statement.setString(1, accountName);
			statement.executeQuery();
			
			//Also add account to lookup table (should be done in SQL with a trigger :: TODO?)
			String sql2 ="INSERT INTO BANK_USERACCOUNTS VALUES(USERACCOUNT_SEQUENCE.NEXTVAL, ACCOUNTLINK_SEQUENCE.NEXTVAL,?)"; 
			PreparedStatement statement2 = ConnectionUtil.connection.prepareStatement(sql2);
			statement2.setInt(1, owner.getId());
			statement2.executeQuery();
			
			System.out.println("Account created!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	//Deletes an account using a callable procedure, actually nullifies the password
	public void deleteAccount(Account account) {
		try {

			String sql = "{call DELETE_BANK_ACCOUNT(?)}";
			CallableStatement statement = ConnectionUtil.connection.prepareCall(sql);
			statement.setInt(1, account.getAccountID());
			statement.execute();
			
			System.out.println("Account deleted!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	//Deposit an amount to the specified account
	public void deposit(User owner, Account account, float amount) {
		
		try {
			String sql = "UPDATE BANK_ACCOUNT SET AMOUNT=? WHERE ACCOUNTID=?";
			PreparedStatement statement = ConnectionUtil.connection.prepareStatement(sql);
			statement.setFloat(1, account.getBalance() + amount);
			statement.setInt(2, account.getAccountID());
			statement.executeQuery();
			
			System.out.println("Deposit Complete!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		account.updateBalance();
	}

	//Withdraws an amount from a specified account
	public void withdraw(User owner, Account account, float amount) throws OverdraftException{
		
		//Overdraft protection
		if(account.getBalance() < amount) throw new OverdraftException();
		
		try {
			String sql = "UPDATE BANK_ACCOUNT SET AMOUNT=? WHERE ACCOUNTID=?";
			PreparedStatement statement = ConnectionUtil.connection.prepareStatement(sql);
			statement.setFloat(1, account.getBalance() - amount);
			statement.setInt(2, account.getAccountID());
			statement.executeQuery();
			
			System.out.println("Withdraw Complete!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		account.updateBalance();
	}

	//Gets the updated balance for the current account
	public float updateBalance(Account account) {

		try {
			String sql = "SELECT AMOUNT FROM BANK_ACCOUNT WHERE ACCOUNTID=?";
			
			PreparedStatement statement = ConnectionUtil.connection.prepareStatement(sql);
			statement.setInt(1, account.getAccountID());
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				return rs.getFloat(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Unable to update balance!");
		return account.getBalance();
	}

}
