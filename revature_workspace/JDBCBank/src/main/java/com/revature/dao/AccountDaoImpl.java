package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.util.ConnectionUtil;

import Beans.Account;

public class AccountDaoImpl implements AccountDao{
	private static String filename = "connection.properties";
	
	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	public Account getAccountById() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addAccount(Account account)
	{

		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			conn.setAutoCommit(false);
			System.out.println("In try statement");
			/*java.sql.Date birthday =(java.sql.Date)bear.getBirthdate();
			PreparedStatement prepStmt=con.prepareStatement("INSERT INTO BEAR VALUES(?,?,?,?,?)");
			prepStmt.setString(1,bear.getName());
			prepStmt.setInt(2, bear.getCave().getId());
			prepStmt.setInt(3, bear.getBearType().getId());
			prepStmt.setInt(4,bear.getWeight());
			prepStmt.setDate(5, birthday);	
			prepStmt.execute();*/
			conn.commit();

		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}
		
	}

}
