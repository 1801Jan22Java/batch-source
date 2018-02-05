package com.revature.JDBCBank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

class JDBCBankDAOImpl implements JDBCBankDAO{
	
	private static String filename = "Connections.properties";
	
	createAccountRow(String username, String accountName){
		//if user has account with that name
		String sql = "INSERT INTO USER_ACCOUNT VALUES('"+username+"','"+accountName+"');";
		executeSQLQuery(sql);
	}
	
	deleteAccountRow(int accountID){
		//check account is empty
		String sql = "DELETE FROM ACCOUNT WHERE ACCOUNT.ACCOUNT_ID = accountID";
		executeSQLQuery(sql);
	}
	
	alterAccountBalance(String accountID, double amount){
		//get balance, check won't be negative
		//sum balance with ammount, 
		String sql = "UPDATE ACCOUNT SET BALANCE = amount WHERE ACCOUNT.ACCOUNT_ID = accountID;"
	}
	
	depositAccountRow(String accountName, double amount);
	
	viewUserRow(String username);
	createUserRow(String username, String password);
	deleteUserRow(String username);
	updateUserRow(String username);
	
	viewUserTable();
	updateUserTable();
	deleteUserTable();
	
	private void executeSQLQuery(String sql) {
		PreparedStatement pmst = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			pmst = con.prepareStatement(sql);
			pmst.executeQuery();
			con.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		  catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
}