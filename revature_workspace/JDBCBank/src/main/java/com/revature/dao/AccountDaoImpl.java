package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.util.ConnectionUtil;

import Beans.Account;
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
	public void deposit(int accountID, float amount) {
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			conn.setAutoCommit(false);
			System.out.println("In try statement for deposit");
			String sqlStmt="{CALL SP_MAKE_DEPOSIT(?,?)}";
			CallableStatement cs = conn.prepareCall(sqlStmt);
			cs.setInt(1,accountID);
			cs.setFloat(2,amount);
			cs.execute();
			conn.commit();

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
	public void withdrawal(User user,int accountID, float amount) throws OverdraftException {
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
				CallableStatement cs = conn.prepareCall(sqlStmt);
				cs.setInt(1,accountID);
				cs.setFloat(2,amount);

				cs.execute();
				conn.commit();
			}

		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public Account getAccountById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectAction(int option) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showBalances(User user, int accountID) {
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{

			if(!validateAccount(user,accountID))
			{
				System.out.println("You must be logged in to see account information");
			}
			else{
				conn.setAutoCommit(false);
				System.out.println("In try statement for withdrawal");
				String sqlStmt="SELECT BALANCE FROM ACCOUNT_ID WHERE ACCOUNT_ID=?";
				PreparedStatement ps = conn.prepareStatement(sqlStmt);
				ps.setInt(1,accountID);
				ps.execute();
				ResultSet rs =ps.getResultSet();
				while(rs.next())
				{
					float balance =rs.getFloat("BALANCE");
				}
			}

		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}

	}



}
