package com.revature.dao;

import com.revature.beans.BankAccount;
import com.revature.beans.Transaction;
import com.revature.beans.User;
import com.revature.beans.UserType;
import com.revature.main.GeneralUser;
import com.revature.main.SuperUser;
import com.revature.util.ConnectionUtil;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao
{
	private static String filename = "connection.properties";
	
	public List<User> getUsers()
	{
		List<User> users = new ArrayList<User>();
		UserTypeDaoImpl userTypes = new UserTypeDaoImpl();
		BankAccountDaoImpl accounts = new BankAccountDaoImpl();
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT * FROM USERS";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next())
			{
				int id = rs.getInt("USER_ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("USER_PASSWORD");
				int type = rs.getInt("USER_TYPE_ID");
				UserType userType = userTypes.getUserTypeById(type);
				ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
				for(BankAccount b : accounts.getBankAccounts())
					if(b.getId() == id)
						bankAccounts.add(b);
				
				if(userType.getName().equalsIgnoreCase("General"))
					users.add(new GeneralUser(id, firstName, lastName, username, password, userType, bankAccounts));
				else if(userType.getName().equalsIgnoreCase("Super"))
					users.add(new SuperUser(id, firstName, lastName, username, password, userType));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return users;
	}
	/*
	public List<User> getUsers()
	{
		List<User> users = new ArrayList<User>();
		UserTypeDaoImpl userTypes = new UserTypeDaoImpl();
		BankAccountDaoImpl accounts = new BankAccountDaoImpl();
		PreparedStatement pstmt = null;

		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			con.setAutoCommit(false);
			String sql = "SELECT * FROM USERS";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("USER_ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("USER_PASSWORD");
				int type = rs.getInt("USER_TYPE_ID");
				UserType userType = userTypes.getUserTypeById(type);
				ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
				for(BankAccount b : accounts.getBankAccounts())
				{
					if(b.getId() == id)
						bankAccounts.add(b);
				}
				
				if(userType.getName().equalsIgnoreCase("General"))
					users.add(new GeneralUser(id, firstName, lastName, username, password, userType, bankAccounts));
				else if(type == 2)
					users.add(new SuperUser(id, firstName, lastName, username, password, userType));
				con.commit();
			}
			con.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		return users;
	}
	*/
	
	public User getUserById(int id)
	{
		User user = null;
		UserTypeDaoImpl userTypes = new UserTypeDaoImpl();
		BankAccountDaoImpl accounts = new BankAccountDaoImpl();
		TransactionDaoImpl transactions = new TransactionDaoImpl();
		
		PreparedStatement pstmt = null;

		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			con.setAutoCommit(false);
			String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("USER_PASSWORD");
				int type = rs.getInt("USER_TYPE_ID");
				UserType userType = userTypes.getUserTypeById(type);
				ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
				for(BankAccount b : accounts.getBankAccounts())
				{
					if(b.getId() == id)
						bankAccounts.add(b);
				}
				ArrayList<Transaction> transactionsHistory = new ArrayList<Transaction>();
				for(Transaction t : transactions.getTransactions())
				{
					if(t.getId() == id)
						transactionsHistory.add(t);
				}
				if(userType.getName().equalsIgnoreCase("General"))
					user = new GeneralUser(id, firstName, lastName, username, password, userType, bankAccounts);
				else if(userType.getName().equalsIgnoreCase("Super"))
					user = new SuperUser(id, firstName, lastName, username, password, userType);
				con.commit();
			}
			con.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		return user;
	}

	public void createUser(User user)
	{
		Connection con = null;
		try
		{
			con = ConnectionUtil.getConnectionFromFile(filename);
			con.setAutoCommit(false);
			String sql = "INSERT INTO USERS (FIRSTNAME, LASTNAME, USERNAME, USER_PASSWORD, USER_TYPE_ID)"
					+" VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getPassword());
			pstmt.setInt(5, user.getUserType().getId());
			pstmt.executeUpdate();
			con.commit();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			try
			{
				con.rollback();
			} 
			catch (Exception e1)
			{
				e.printStackTrace();
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		if (con != null)
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}

	public void deleteUser(User user)
	{
		CallableStatement cs = null;
		try
		{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			con.setAutoCommit(false);
			String sql = "{call DELETE_USER(?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1,user.getId());
			cs.execute();
			con.commit();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void updateUser(User user, String firstName, String lastName, String username, String password, UserType userType)
	{
		CallableStatement cs = null;
		try
		{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			con.setAutoCommit(false);
			String sql = "{call UPDATE_USER(?,?,?,?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, user.getId());
			cs.setString(2, firstName);
			cs.setString(3, lastName);
			cs.setString(4, username);
			cs.setString(5, password);
			cs.setInt(6, userType.getId());
			cs.execute();
			con.commit();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
