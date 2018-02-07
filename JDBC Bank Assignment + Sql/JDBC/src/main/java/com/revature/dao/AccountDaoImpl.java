package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Members;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao{

private static String filename = "connection.properties";

public List<Account> getAccounts(){
	List<Account> cl = new ArrayList<>();
	
	try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
		//using a Statement - beware SQL injection
		String sql = "SELECT * FROM MEMBERS_ACCOUNT";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			int id = rs.getInt("ACCOUNTID");
			long balance = rs.getLong("BALANCE");
			//String name = rs.getString("FIRSTNAME");
			//int maxBears = rs.getInt("MAX_BEARS");
			cl.add(new Account(id, balance));
		}
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return cl;
}







public void createAccount(String username, String firstName, String lastName, String password, long balance) {
	
	
	balance = 0;
	try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
		PreparedStatement stmt=con.prepareStatement("INSERT INTO MEMBERS (FIRSTNAME, LASTNAME, USERNAME, PWORD, BALANCE) values(?,?,?,?,?)");  
		stmt.setString(1,username);
		stmt.setString(2,firstName );
		stmt.setString(3,lastName);
		stmt.setString(4,password);
		stmt.setLong(5,0);
		int i=stmt.executeUpdate();
		con.close();
		}
		
	 catch (SQLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	
}

	

public void deposit(long amount, String username) {
	
	
	try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
		PreparedStatement stmt=con.prepareStatement("UPDATE MEMBERS SET BALANCE = BALANCE + ? where USERNAME = ?");  
		stmt.setLong(1,amount);
		stmt.setString(2,username );
		int i=stmt.executeUpdate();
		con.close();
		}
		
	 catch (SQLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}


public void withdraw(long amount, String username) {
	try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
		PreparedStatement stmt=con.prepareStatement("UPDATE MEMBERS SET BALANCE = BALANCE - ? where USERNAME = ?");  
		stmt.setLong(1,amount);
		stmt.setString(2,username );
		int i=stmt.executeUpdate();
		con.close();
		}
		
	 catch (SQLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}


}