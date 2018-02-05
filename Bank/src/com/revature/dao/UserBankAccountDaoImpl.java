package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.beans.UserBankAccount;
import com.revature.util.ConnectionUtil;

public class UserBankAccountDaoImpl implements UserBankAccountDao {

	private static String filename = "connection.properties";
	/* (non-Javadoc)
	 * @see com.revature.dao.UserBankAccountDao#getUserBankAccounts()
	 */
	@Override
	public List<UserBankAccount> getUserBankAccounts() 
	{
		List<UserBankAccount> uba = new ArrayList<>();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT * FROM USER_BANK_ACCOUNTS";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				int accountid = rs.getInt("ACCOUNT_ID");
				int userid = rs.getInt("USER_ID");
				uba.add(new UserBankAccount(userid, accountid));
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
		return uba;
	}
	
	/* (non-Javadoc)
	 * @see com.revature.dao.UserBankAccountDao#getUserBankAccountbyId(int, int)
	 */
	@Override
	public UserBankAccount getUserBankAccountbyId(int userid, int account) 
	{
		PreparedStatement pstmt = null;
		UserBankAccount uba = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT * FROM USER_BANK_ACCOUNT WHERE ACCOUNT_ID = ? AND USER_ID = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,userid);
			pstmt.setInt(2, account);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.UserBankAccountDao#addUserBankAccount(com.revature.beans.UserBankAccount)
	 */
	@Override
	public int addUserBankAccount(UserBankAccount uba) 
	{
		int ubaCreated =0;
		Connection con = null;
		try
		{
			con = ConnectionUtil.getConnectionFromFile(filename);
			con.setAutoCommit(false);
			String sql = "INSERT INTO USER_BANK_ACCOUNTS VALUES (?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, uba.getUserID());
			pstmt.setInt(2, uba.getAccountID());
			ubaCreated = pstmt.executeUpdate();
			con.commit();
		}//try
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
		return ubaCreated;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.UserBankAccountDao#numOfAccounts(com.revature.beans.User)
	 */
	@Override
	public int numOfAccounts(User user) {

		int userid = user.getUserID();
		List<UserBankAccount> uba = new ArrayList<>();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT * FROM USER_BANK_ACCOUNTS WHERE USER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				int accountid = rs.getInt("ACCOUNT_ID");
				uba.add(new UserBankAccount(userid, accountid));
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
		return uba.size();
	}
	

}
