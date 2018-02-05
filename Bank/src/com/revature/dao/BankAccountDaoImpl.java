package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.util.ConnectionUtil;

public class BankAccountDaoImpl implements BankAccountDao{

	private static String filename = "connection.properties";
	
	/* (non-Javadoc)
	 * @see com.revature.dao.BankAccountDao#getBankAccounts()
	 */
	@Override
	public List<BankAccount> getBankAccounts() {
		List<BankAccount> accounts = new ArrayList<>();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT * FROM BANK_ACCOUNT";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("ACCOUNT_ID");
				double curBal = rs.getDouble("CURRENT_BALANCE");
				int type = rs.getInt("ACCOUNT_TYPE");
				accounts.add(new BankAccount(id,curBal, type));
			}//end while
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
		return accounts;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.BankAccountDao#getBankAccountById(int)
	 */
	@Override
	public BankAccount getBankAccountById(int id)
	{
		PreparedStatement pstmt = null;
		BankAccount account = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT * FROM BANK_ACCOUNT WHERE ACCOUNT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				double curBal = rs.getDouble("CURRENT_BALANCE");
				int type = rs.getInt("ACCOUNT_TYPE");
				account = new BankAccount(id, curBal, type);
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
		return account;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.BankAccountDao#viewBalance(int)
	 */
	@Override
	public double viewBalance(int id) 
	{
		PreparedStatement pstmt = null;
		//BankAccount account = null;
		double balance =0;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT CURRENT_BALANCE FROM BANK_ACCOUNT WHERE ACCOUNT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				balance = rs.getDouble("CURRENT_BALANCE");
				//int type = rs.getInt("ACCOUNT_TYPE");
				//account = new BankAccount(id, curBal, type);
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
		return balance;
	}

	

	/* (non-Javadoc)
	 * @see com.revature.dao.BankAccountDao#withdrawFromAccount(int, int, double)
	 */
	@Override
	public double withdrawFromAccount(int userid, int accountid, double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.BankAccountDao#makeDeposit(int, int, double)
	 */
	@Override
	public double makeDeposit(int userid, int accountid, double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.BankAccountDao#deleteAccount(int)
	 */
	@Override
	public int deleteAccount(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.BankAccountDao#addAccount(com.revature.beans.BankAccount)
	 */
	@Override
	public int addAccount(BankAccount account) 
	{
		int accountsCreated = 0;
		Connection con = null;
		try
		{
			con = ConnectionUtil.getConnectionFromFile(filename);
			con.setAutoCommit(false);
			String sql = "INSERT INTO (CURRENT_BALANCE, ACCOUNT_TYPE) BANK_ACCOUNT VALUES (?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			//pstmt.setInt(1, account.getAccountID());
			pstmt.setDouble(1, account.getCurrentBalance());
			pstmt.setInt(2, account.getAccountType());
			accountsCreated = pstmt.executeUpdate();
			con.commit();
		}//end of try block
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
		catch (IOException e1) 
		{
			e1.printStackTrace();
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
		return accountsCreated;
	}

	

}
