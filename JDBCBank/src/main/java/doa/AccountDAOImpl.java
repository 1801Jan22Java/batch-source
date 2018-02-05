package doa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import beans.Account;
import util.ConnectionUtil;
import util.NotEnoughMoneyException;

public class AccountDAOImpl implements AccountDAO
{
	private static String filename = "Properties";
	@Override
	public ArrayList<Account> getAccounts() {
		ArrayList<Account> act = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT * FROM ACCOUNT";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				int accountId = rs.getInt("ACCOUNT_ID");
				int userId = rs.getInt("USER_ID");
				int accountType = rs.getInt("ACCOUNT_TYPE");
				float balance = rs.getFloat("BALANCE");
				Account a = new Account(accountId, userId, accountType, balance);
				act.add(a);
			}
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return act;
	}

	@Override
	public ArrayList<Account> getAccountsByUser(int u) 
	{
		ArrayList<Account> acts = this.getAccounts();
		ArrayList<Account> uacts = new ArrayList<Account>();
		for(Account a: acts)
		{
			if(a.getUserId()==u)
			{
				uacts.add(a);
			}
		}
		return uacts;
	}

	@Override
	public Account createAccount(int accountId, int userId, int accountType, float balance) 
	{
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "INSERT INTO ACCOUNT(ACCOUNT_ID, USER_ID, ACCOUNT_TYPE, BALANCE) VALUES(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, accountId);
			pstmt.setInt(2, userId);
			pstmt.setInt(3, accountType);
			pstmt.setFloat(4, balance);
			//pstmt.execute();
			pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return new Account(accountId, userId, accountType, balance);
	}

	@Override
	public void removeAccount(int accountId) 
	{	
		PreparedStatement pstmt = null;
		try (
			Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "DELETE FROM ACCOUNT WHERE ACCOUNT_ID = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, accountId);
			//pstmt.execute();
			pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public float updateAccount(float f, Account a) throws NotEnoughMoneyException {
		float newBalance = a.getBalance()+f;
		if(newBalance < 0)
		{
			throw new NotEnoughMoneyException();
		}
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "UPDATE ACCOUNT SET BALANCE = ? WHERE ACCOUNT_ID = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setFloat(1, newBalance);
			pstmt.setInt(2, a.getAccountid());
			//pstmt.execute();
			pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return 0;
	}

}
