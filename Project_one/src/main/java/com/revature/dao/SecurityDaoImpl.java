package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.beans.Customer;
import com.revature.util.ConnectionUtil;

public class SecurityDaoImpl implements SecurityDao {
	private static String filename = "Connection.properties";
	private static int UserID;

	public static int getUserID() {
		return UserID;
	}



	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean check_Availability(String username) {
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			PreparedStatement stmt = con.prepareStatement("select * from security where username = ?" );
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return false;
			}else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean check_AccountNumber(int accounts) {
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			PreparedStatement stmt = con.prepareStatement("select * from accounts where accountid = ? " );
			stmt.setInt(1, accounts);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean check_Credentials(String username, String password) {
		String stored_username = null, stored_password = null;
		boolean verify = false;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			
			PreparedStatement statement = con.prepareStatement("select * from security where username = ?");
			//"select * from security where username = ?"
			statement.setString(1, username);
			System.out.println("got here 3");
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {

			this.UserID = rs.getInt(1);
			System.out.println(this.UserID+"_______"+rs.getString(2));
			
			stored_username =rs.getString(2);
			System.out.println("Got the username = "+ stored_username );
			stored_password = rs.getString(3);
				
				
			
			if(username.equals(stored_username) && password.equals(stored_password)) {
				verify = true;
				return true;
			}else {
				return false;
			}
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (verify == true) {
			return true;
		}else {
		return false;
		}
	}




	


}
