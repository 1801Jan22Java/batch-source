package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.exceptions.BalanceNotZeroException;
import com.revature.exceptions.InvalidAccountIDException;
import com.revature.exceptions.InvalidPasswordException;
import com.revature.exceptions.OverdraftException;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao{
	
	public void createAccount(User u) {
		Account account = null;
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			Scanner sc = new Scanner(System.in);
			double balanceToDeposit = 0;
			
			System.out.println("How much would you like to put into your new account?");
			balanceToDeposit = sc.nextDouble();
			sc.nextLine();
			
			CallableStatement cs = null;
			String sql = "{call CREATE_ACCOUNT(?,?)}";
			cs = conn.prepareCall(sql);
			cs.setDouble(1, balanceToDeposit);
			cs.setInt(2, u.getUserId());
			cs.execute();
			
			System.out.println();
			System.out.println("$" + balanceToDeposit + " deposited into your new account, " + u.getFirstName() + ".");
			System.out.println("Take a look at your new account by entering VIEW in the main menu!");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Allows user to view their accounts. Can make withdrawls and deposits by selecting an account.
	public void viewAccount(User u) {
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			AccountDaoImpl adi = new AccountDaoImpl();
			Scanner sc = new Scanner(System.in);
			pstmt = conn.prepareStatement("SELECT * FROM ACCOUNTS WHERE USER_ID=?");
			pstmt.setInt(1,u.getUserId());
			rs = pstmt.executeQuery();
			
			ArrayList<Integer> accNumbers = new ArrayList<Integer>();
			int currAcc;
			while(rs.next()) {
				currAcc = rs.getInt("BANK_ACCOUNT_ID");
				accNumbers.add(currAcc);
				System.out.println();
				System.out.println("Account ID: " + currAcc);
				System.out.println("Balance   : $" + rs.getDouble("BALANCE"));
			}
			
			//indexOf() == -1 if index not found
			
			int response = 0;
			String responseStr;
			while(response != -1) {
				System.out.println();
				System.out.println("Select the ID of the Account you'd like to view.");
				System.out.println("Enter -1 if you'd like to go back to the main menu.");
				response = sc.nextInt();
				sc.nextLine();
				
				//If their entered account number is one of their accounts
				try {
					if(accNumbers.indexOf(response) != -1) {
						//Ask if they want to make a withdrawl or deposit
						System.out.println();
						System.out.println("Would you like to WITHDRAW from, DEPOSIT into or DELETE this account?");
						responseStr = sc.nextLine();
						
						responseStr = responseStr.toUpperCase();
						switch(responseStr) {
						case "WITHDRAW"	:	adi.withdraw(response);
											break;
						case "DEPOSIT"	:	adi.deposit(response);
											break;
						case "DELETE"	:	adi.deleteAccount(response);
											break;
						default			:	break;
						}
					}
					else if (response != -1){
						throw new InvalidAccountIDException("Invalid Account ID. Please enter another.");
					}
				} catch (InvalidAccountIDException i) {
					System.err.println(i);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAccount(int accID) {
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Scanner sc = new Scanner(System.in);

			pstmt = conn.prepareStatement("SELECT * FROM ACCOUNTS WHERE BANK_ACCOUNT_ID=?");
			pstmt.setInt(1,accID);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			try {
				if(rs.getDouble("BALANCE") != 0) {
					throw new BalanceNotZeroException("Make sure your balance is $0.00 before you close this account!");
				}
				
				else {
					CallableStatement cs = null;
					String sql = "{call DELETE_ACCOUNT(?)}";
					cs = conn.prepareCall(sql);
					cs.setInt(1, accID);
					cs.execute();
					
					System.out.println("Account successfully deleted!");
				}
			} catch (BalanceNotZeroException bnze) {
				System.err.println(bnze);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public double withdraw(int accID) {
		Scanner sc = new Scanner(System.in);
		double newBalance = 0;
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			System.out.println("How much would you like to withdraw?");
			double withdrawAmt = sc.nextDouble();

			pstmt = conn.prepareStatement("SELECT BALANCE FROM ACCOUNTS WHERE BANK_ACCOUNT_ID=?");
			pstmt.setInt(1,accID);
			rs = pstmt.executeQuery();
			
			rs.next();
			try {
				newBalance = rs.getDouble("BALANCE");
				if(withdrawAmt > rs.getDouble("BALANCE")) {
					throw new OverdraftException("You don't have that much money in that account! Balance: " + rs.getDouble("BALANCE"));
				}
				
				//Withdraw the amount from accID
				CallableStatement cs = null;
				String sql = "{call WITHDRAW(?,?)}";
				cs = conn.prepareCall(sql);
				cs.setInt(1, accID);
				cs.setDouble(2, withdrawAmt);
				cs.execute();
				
				pstmt = conn.prepareStatement("SELECT BALANCE FROM ACCOUNTS WHERE BANK_ACCOUNT_ID=?");
				pstmt.setInt(1,accID);
				rs = pstmt.executeQuery();
				
				rs.next();
				
				newBalance = rs.getDouble("BALANCE");
				System.out.println("Your new balance in account " + accID + ": " + newBalance);
				
			} catch (OverdraftException oe) {
				System.err.println(oe);
			}
			return newBalance;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newBalance;
	}
	
	public double deposit(int accID) {
		Scanner sc = new Scanner(System.in);
		double newBalance = 0;
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			
			System.out.println("How much would you like to deposit?");
			double depositAmt = sc.nextDouble();
			
			//Withdraw the amount from accID
			CallableStatement cs = null;
			String sql = "{call DEPOSIT(?,?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, accID);
			cs.setDouble(2, depositAmt);
			cs.execute();
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			pstmt = conn.prepareStatement("SELECT BALANCE FROM ACCOUNTS WHERE BANK_ACCOUNT_ID=?");
			pstmt.setInt(1,accID);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			newBalance = rs.getDouble("BALANCE");
			System.out.println("Your new balance in account " + accID + ": " + newBalance);
			
			return newBalance;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newBalance;
	}
	
	
	
}
