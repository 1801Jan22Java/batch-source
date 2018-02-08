package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.AccountType;
import com.revature.beans.BankAccount;
import com.revature.beans.Transaction;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class BankAccountDaoImpl implements BankAccountDao
{
	private static String filename = "connection.properties";
	
	public List<BankAccount> getBankAccounts()
	{
		List<BankAccount> bankAccounts = new ArrayList<BankAccount>();
		UserDaoImpl users = new UserDaoImpl();
		AccountTypeDaoImpl types = new AccountTypeDaoImpl();
		TransactionDaoImpl transactions = new TransactionDaoImpl();
		PreparedStatement pstmt = null;

		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM BANK_ACCOUNTS";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("BANK_ACCOUNT_ID");
				int userId = rs.getInt("USER_ID");
				float balance = rs.getFloat("BALANCE");
				int type = rs.getInt("BANK_ACCOUNT_TYPE_ID");

				User user = users.getUserById(userId);
				AccountType accountType = types.getAccountTypeById(type);
				ArrayList<Transaction> transactionsHistory = new ArrayList<Transaction>();
				for(Transaction t : transactions.getTransactions())
				{
					if(t.getId() == id)
						transactionsHistory.add(t);
				}
				bankAccounts.add(new BankAccount(id, user, balance, accountType, transactionsHistory));
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
		return bankAccounts;
	}

	public BankAccount getBankAccountById(int id)
	{
		BankAccount bankAccount = null;
		UserDaoImpl users = new UserDaoImpl();
		AccountTypeDaoImpl types = new AccountTypeDaoImpl();
		TransactionDaoImpl transactions = new TransactionDaoImpl();
		PreparedStatement pstmt = null;

		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM BANK_ACCOUNTS WHERE BANK_ACCOUNT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				int userId = rs.getInt("USER_ID");
				float balance = rs.getFloat("BALANCE");
				int type = rs.getInt("BANK_ACCOUNT_TYPE_ID");

				User user = users.getUserById(userId);
				AccountType accountType = types.getAccountTypeById(type);
				ArrayList<Transaction> transactionsHistory = new ArrayList<Transaction>();
				for(Transaction t : transactions.getTransactions())
				{
					if(t.getId() == id)
						transactionsHistory.add(t);
				}
				bankAccount = new BankAccount(id, user, balance, accountType, transactionsHistory);
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
		return bankAccount;
	}

	public void createBankAccount(BankAccount account)
	{
		Connection con = null;
		try
		{
			con = ConnectionUtil.getConnectionFromFile(filename);
			con.setAutoCommit(false);
			String sql = "INSERT INTO BANK_ACCOUNTS (USER_ID, BALANCE, BANK_ACCOUNT_TYPE_ID)"
					+" VALUES(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, account.getUser().getId());
			pstmt.setFloat(2, account.getBalance());
			pstmt.setInt(3, account.getType().getId());
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

	public void deleteBankAccount(BankAccount account)
	{
		CallableStatement cs = null;
		try
		{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "{call DELETE_BANK_ACCOUNT(?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1,account.getId());
			cs.execute();
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

	public void updateBankAccount(BankAccount account, User user, float balance, AccountType type)
	{
		CallableStatement cs = null;
		try
		{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "{call UPDATE_BANKACCOUNT(?,?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, account.getId());
			cs.setInt(2, user.getId());
			cs.setFloat(3, balance);
			cs.setInt(4, type.getId());
			cs.execute();
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
