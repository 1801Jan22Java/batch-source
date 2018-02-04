package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.Exceptions.OverdraftException;
import com.revature.Exceptions.ZeroBalanceException;
import com.revature.util.ConnectionUtil;

import Beans.Account;
import Beans.CheckingAccount;
import Beans.SavingsAccount;
import Beans.User;

public class AccountDaoImpl implements AccountDao{
	private static String filename = "connection.properties";

	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	public Account getAccountById(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAccount(Account account,User user)
	{

		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			UserDaoImpl udi = new UserDaoImpl();
			conn.setAutoCommit(false);
			System.out.println("In try statement");
			String sqlStmt="{CALL SP_NEW_ACCOUNT(?,?,?)}";
			CallableStatement cs = conn.prepareCall(sqlStmt);
			cs.setInt(1,account.getAccountType().getAccountTypeID());
			cs.setFloat(2,account.getBalance());
			cs.setInt(3,udi.getUserID(user));
			cs.execute();
			conn.commit();

		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void deposit(int accountID, float amount, User user) {

		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			if(!validateAccount(user,accountID))
			{
				System.out.println("You must be logged in to make a withdrawal");
			}
			else{
				conn.setAutoCommit(false);
				System.out.println("In try statement for deposit");
				String sqlStmt="{CALL SP_MAKE_DEPOSIT(?,?)}";
				CallableStatement cs = conn.prepareCall(sqlStmt);
				cs.setInt(1,accountID);
				cs.setFloat(2,amount);
				cs.execute();
				conn.commit();
				showBalance(user,accountID);
			}
		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}

	}
	public boolean validateAccount(User user, int accountID)
	{
		boolean accountValid=false;
		try(Connection conn=ConnectionUtil.getConnectionFromFile(filename))
		{
			UserDaoImpl upi=new UserDaoImpl();
			if(upi.validateCredentials(user.getUserName(),user.getPassword()))
			{
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM ACCOUNTS WHERE ACCOUNT_ID = ? AND USER_ID IN("
						+ "SELECT USER_ID FROM USERS WHERE USER_NAME=? AND USER_PASS=?)");
				ps.setInt(1, accountID);
				ps.setString(2, user.getUserName());
				ps.setString(3, user.getPassword());
				ps.execute();
				ResultSet rs = ps.getResultSet();
				while (rs.next())
				{
					System.out.println("ACCOUNT!!");
					System.out.println(rs.getInt("ACCOUNT_ID"));
					accountValid=true;
				}
			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountValid;
	}

	@Override
	public void withdrawal(User user,int accountID, float amount) throws OverdraftException  {
		float currentBalance=0.0f;
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{

			if(!validateAccount(user,accountID))
			{
				System.out.println("You must be logged in to make a withdrawal");
			}
			else{
				conn.setAutoCommit(false);
				System.out.println("In try statement for withdrawal");
				String sqlStmt="{CALL SP_MAKE_WITHDRAWAL(?,?)}";
				PreparedStatement ps = conn.prepareStatement("SELECT BALANCE FROM ACCOUNTS WHERE ACCOUNT_ID=?");
				ps.setInt(1, accountID);
				ps.execute();
				ResultSet rs = ps.getResultSet();
				if(rs.next())
				{
					currentBalance = rs.getFloat("BALANCE");
				}
				if(currentBalance<amount)
				{
					throw new OverdraftException("You may not withdraw more than what is in the account");
				}
				CallableStatement cs = conn.prepareCall(sqlStmt);
				cs.setInt(1,accountID);
				cs.setFloat(2,amount);

				cs.execute();
				conn.commit();
				showBalance(user,accountID);
			}

		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}

	}


	@Override
	public Account getAccountById() {
		// TODO Auto-generated method stub
		return null;
	}

	public void showMenu(User user)
	{
		UserDaoImpl udi = new UserDaoImpl();
		Scanner sc = new Scanner(System.in);
		if(udi.validateSuperUser(user)){
			System.out.println("Please make a selection:\n 1: View balance "
					+ "\n2: Make deposit\n3: Make withdrawal\n4:Close account."
					+ "\n5: Create account.\n6: Delete user\n 7: Create user\n10: Log out");
		}
		else
		{
			System.out.println("Please make a selection:\n 1: View balance "
					+ "\n2: Make deposit\n3: Make withdrawal\n4:Close account."
					+ "\n5: Create account.\n10: Log out");
		}
		try{
		int newOption = sc.nextInt();
		selectAction(newOption, user);	
		}
		catch(NumberFormatException e)
		{
			System.out.println("You must input a number value");
			e.printStackTrace();
		}
		
	}
	@Override
	public void selectAction(int option, User user) {
		UserDaoImpl udi = new UserDaoImpl(); 
		Scanner sc = new Scanner(System.in);
		switch(option)
		{
		case 1: 
			System.out.println("Please enter the account ID."); 
			int accountID = sc.nextInt(); 
			showBalance(user,accountID); 
			showMenu(user);
			break;
		case 2: System.out.println("Please enter the account ID."); 
		accountID = sc.nextInt(); 
		System.out.println("Please choose an amount to deposit.");
		float amount = sc.nextFloat();
		deposit(accountID,amount,user); 
		showMenu(user);
		break;
		case 3 :System.out.println("Please enter the account ID."); 
		accountID = sc.nextInt(); 
		System.out.println("Please choose an amount to withdraw.");
		amount = sc.nextFloat();
		try{
			withdrawal(user,accountID,amount); }
		catch(OverdraftException e)
		{
			e.printStackTrace();
		}
		finally{
			showMenu(user);
		}
		break;	
		case 4: System.out.println("Please enter the account ID to close");
		accountID=sc.nextInt();
		closeAccount(user,accountID);
		showMenu(user);
		break;
		case 5:System.out.println("Would you like a checking or a savings account?  "
				+ "Enter 1 for a savings account.  Enter 2 for a checking account");

		int userID = udi.getUserID(user);
		int choice =sc.nextInt();
		System.out.println("Please enter your initial balance");
		float initbal=sc.nextFloat();
		Account account =null;
		try{
			if(initbal==0){ 
				throw new ZeroBalanceException("Your initial balance must be greater than zero");
			}
			else{
				switch(choice){
				case 1: 


					account = new SavingsAccount(initbal,userID) ;
					addAccount(account,user); break;



				case 2:
					account = new CheckingAccount(initbal,userID) ;
					addAccount(account,user); break;
				}
			}
		}
		catch(ZeroBalanceException e){
			e.printStackTrace();
		}
		finally{
			showMenu(user);
			break;
		}
		case 6: 
			System.out.println("Please enter the user ID of the user you want to delete");
			userID=sc.nextInt();
			User user2 = udi.getUserById(userID);
			System.out.println("User attempting the deletion");
			System.out.println(udi.getUserID(user));
			udi.deleteUser(user, user2);
			showMenu(user);
			break;
		case 7:
			udi.addUser(user);
			showMenu(user); 
			break;
		case 10: user=udi.logout();break;
		default: 
			System.out.println("Invalid choice");
			showMenu(user);
		}

	}

	@Override
	public void showBalance(User user, int accountID) {
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{

			if(!validateAccount(user,accountID))
			{
				System.out.println("You must be logged in to see account information");
			}
			else{
				conn.setAutoCommit(false);
				System.out.println("In try statement for showing balance");
				String sqlStmt="SELECT BALANCE FROM ACCOUNTS WHERE ACCOUNT_ID=?";
				PreparedStatement ps = conn.prepareStatement(sqlStmt);
				ps.setInt(1,accountID);
				ps.execute();
				ResultSet rs =ps.getResultSet();
				while(rs.next())
				{
					float balance =rs.getFloat("BALANCE");
					System.out.println("Your balance is: "+balance);
				}
			}

		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void closeAccount(User user, int accountID) {
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{

			if(!validateAccount(user,accountID))
			{
				System.out.println("You must be logged in to see account information");
			}
			else{
				conn.setAutoCommit(false);
				System.out.println("In try statement for showing balance");
				String sqlStmt="SELECT BALANCE FROM ACCOUNTS WHERE ACCOUNT_ID=?";
				PreparedStatement ps = conn.prepareStatement(sqlStmt);
				ps.setInt(1,accountID);
				ps.execute();
				ResultSet rs =ps.getResultSet();
				while(rs.next())
				{
					float balance =rs.getFloat("BALANCE");
					if(balance>0)
					{
						System.out.println("You may not delete an account that has a balance");
					}
					else
					{
						CallableStatement cs = conn.prepareCall("{CALL SP_DELETE_ACCOUNT(?)}");
						cs.setInt(1, accountID);
						cs.execute();
					}
				}
			}

		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}



	}



}
