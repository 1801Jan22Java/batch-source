package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao{
	
	public Account createAccount(User u) {
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
			
			System.out.println("$" + balanceToDeposit + " deposited into your new account, " + u.getFirstName() + ".");
			System.out.println("Take a look at your new account by entering VIEW in the main menu!");
			
			sc.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}
}
