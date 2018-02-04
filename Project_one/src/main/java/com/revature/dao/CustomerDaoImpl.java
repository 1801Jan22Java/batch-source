package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.beans.Customer;
import com.revature.util.ConnectionUtil;

public class CustomerDaoImpl implements CustomerDao {
	public static String filename = "Connection.properties";
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addCustomer(String f_name,String l_name,String username,String password) {
		int customersAdded = 0;
		CallableStatement cs = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			con.setAutoCommit(false);
			String sql = "{call CREATE_NEW_CUSTOMER(?,?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setString(1, f_name);
			cs.setString(2, l_name);
			cs.setString(3, username);
			cs.setString(4, password);
			cs.execute();
			con.commit();
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public void login(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAccount() {
		// TODO Auto-generated method stub
		
	}
	

}
