package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
			String sqlStmt="{CALL NEW_USER_PROC(?,?,?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(sqlStmt);
			cs.setString(1,user.getUserName());
			cs.setString(2,user.getPassword());
			cs.setString(3, user.getFirstName());
			cs.setString(4,user.getLastName());
			cs.setInt(5, user.getSuperUser());
			cs.setString(6, user.getSSN());
			cs.execute();
			conn.commit();

		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}

	}



	@Override
	public void deposit(float amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void withdrawal(float amount) {
		// TODO Auto-generated method stub

	}

}
